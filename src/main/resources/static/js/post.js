document.addEventListener('DOMContentLoaded', () => {
    const postList = document.getElementById('postList');
    const pagination = document.getElementById('pagination');
    const writeBtn = document.getElementById('writeBtn');
    const page = new URLSearchParams(window.location.search).get('page') || 1;

    fetch(`/posts?page=${page}`)
        .then(res => res.json())
        .then(data => {
            postList.innerHTML = data.map(post => `
                <tr onclick="location.href='/postDetail.html?id=${post.id}'">
                    <td>${post.title}</td>
                    <td>${post.writerName}</td>
                    <td>${new Date(post.createdAt).toLocaleString()}</td>
                </tr>`).join('');
        });

    writeBtn.addEventListener('click', () => {
        location.href = '/postForm.html';
    });
});