document.addEventListener('DOMContentLoaded', () => {
    const id = new URLSearchParams(window.location.search).get('id');
    const form = document.getElementById('postForm');
    const token = localStorage.getItem('token');

    if (id) {
        document.getElementById('formTitle').textContent = '글 수정';
        fetch(`/posts/${id}`)
            .then(res => res.json())
            .then(post => {
                document.getElementById('title').value = post.title;
                document.getElementById('content').value = post.content;
            });
    }

    form.addEventListener('submit', e => {
        e.preventDefault();
        const data = {
            title: form.title.value,
            content: form.content.value
        };
        const method = id ? 'PUT' : 'POST';
        const url = id ? `/posts/write/${id}` : '/posts/write';

        fetch(url, {
            method,
            headers: {
                'Content-Type': 'application/json',
                'Authorization': `Bearer ${token}`
            },
            body: JSON.stringify(data)
        }).then(() => location.href = '/post.html');
    });
});
