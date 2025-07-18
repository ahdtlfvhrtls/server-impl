const token = localStorage.getItem('token');
if (!token) {
    alert('로그인이 필요합니다.');
    location.href = '/login';
}

window.onload = async () => {
    try {
        const res = await fetch('/member/info', {
            headers: { Authorization: `Bearer ${token}` }
        });

        if (!res.ok) throw new Error('정보 불러오기 실패');
        const data = await res.json();
        document.getElementById('userId').textContent = data.username;
        document.getElementById('name').value = data.name;
    } catch (err) {
        alert(err.message);
    }
};

document.getElementById('updateBtn').addEventListener('click', async () => {
    const name = document.getElementById('name').value.trim();
    const password = document.getElementById('password').value.trim();

    try {
        const res = await fetch('/member/update', {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
                Authorization: `Bearer ${token}`
            },
            body: JSON.stringify({ name, password })
        });

        if (!res.ok) throw new Error('수정 실패');
        document.getElementById('message').textContent = '정보가 수정되었습니다.';
    } catch (err) {
        document.getElementById('message').textContent = err.message;
    }
});

document.getElementById('logoutBtn').addEventListener('click', () => {
    localStorage.removeItem('token');
    location.href = '/login';
});