document.getElementById('registerForm').addEventListener('submit', async e => {
    e.preventDefault();

    const username = username.value.trim();
    const password = password.value.trim();
    const name = name.value.trim();

    try {
        const res = await fetch('/member/register', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ username, password, name })
        });

        if (!res.ok) throw new Error('가입 실패');

        document.getElementById('message').textContent = '가입 성공!';
        e.target.reset();
    } catch (err) {
        document.getElementById('message').textContent = err.message;
    }
});