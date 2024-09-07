document.addEventListener('DOMContentLoaded', function() {
    const dropdownLinks = document.querySelectorAll('.dropdown-toggle');

    dropdownLinks.forEach(link => {
        link.addEventListener('click', function(event) {
            // 모든 드롭다운 메뉴를 닫기
            const dropdowns = document.querySelectorAll('.dropdown-menu');
            dropdowns.forEach(dropdown => {
                if (dropdown !== event.currentTarget.nextElementSibling) {
                    dropdown.classList.remove('show');
                }
            });

            // 클릭한 드롭다운 메뉴 토글
            const dropdownMenu = event.currentTarget.nextElementSibling;
            dropdownMenu.classList.toggle('show');
        });
    });
});
