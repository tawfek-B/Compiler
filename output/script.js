document.addEventListener("DOMContentLoaded", function () {
    document.querySelectorAll("form[action*='delete']").forEach(function (form) {
        form.addEventListener("submit", function (event) {
            if (!confirm("Are you sure you want to delete this product?")) {
                event.preventDefault();
            }
        });
    });
});