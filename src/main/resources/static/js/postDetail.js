document.addEventListener('DOMContentLoaded', () => {
    const id = new URLSearchParams(window.location.search).get('id');
    const token = localStorage.getItem('token');

    fetch(`/posts/${id}`)
        .then(res => res.json())
        .then(post => {
            document.getElementById('title').textContent = post.title;
            document.getElementById('writerName').textContent = post.writerName;
            document.getElementById('createdAt').textContent = new Date(post.createdAt).toLocaleString();
            document.getElementById('content').textContent = post.content;

            const currentUserId = parseInt(localStorage.getItem('userId'));
            if (post.writerId === currentUserId) {
                document.getElementById('editBtn').addEventListener('click', () => {
                    location.href = `/postForm.html?id=${post.id}`;
                });
                document.getElementById('deleteBtn').addEventListener('click', () => {
                    fetch(`/posts/write/${post.id}`, {
                        method: 'DELETE',
                        headers: { 'Authorization': `Bearer ${token}` }
                    }).then(() => location.href = '/post.html');
                });
            } else {
                document.getElementById('post-actions').style.display = 'none';
            }
        });
});