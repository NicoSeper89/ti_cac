function loadPage(page = 0) {
    $.get('/publications', { page: page }, function(data) {
        $('#publicationsContainer').html(data);
    });
}

$(document).on('click', '.pagination a', function(event) {
    event.preventDefault();
    var page = $(this).data('page');
    if (page !== undefined) {
        loadPage(page);
    }

    $(window).scrollTop($('#news-section').offset().top); 
});

$(document).ready(function() {
    loadPage(0); 
});