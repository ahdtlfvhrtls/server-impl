document.getElementById('loginForm').addEventListener('submit', async e => {
    e.preventDefault();

    const username = username.value.trim();
    const password = password.value.trim();

    try {
        const res = await fetch('/member/login', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ username, password })
        });

        const token = await res.text();
        if (!res.ok || !token) throw new Error('로그인 실패');

        localStorage.setItem('token', token);
        window.location.href = '/post.html';
    } catch (err) {
        document.getElementById('message').textContent = err.message;
    }
});