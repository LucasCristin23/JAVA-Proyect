$(document).ready(function() {
    $('#cliente').click(function() {
        $.ajax({
            url: 'https://randomuser.me/api/?nat=us,dk,fr,gb,es,br,mx,ca', //Acá especifico las nacionalidades de los usuarios que voy a traer de "randomuser.me"
            dataType: 'json',
            success: function(data) {
                let resultado = $('#resultado');
                resultado.html(`
                    <div class="contact-card">
                        <img src="${data.results[0].picture.large}" alt="User Image">
                        <p class="name">${data.results[0].name.first} ${data.results[0].name.last}</p>
                        <p class="email">${data.results[0].email}</p>
                        <p class="location">${data.results[0].location.city}, ${data.results[0].location.country}</p>
                    </div>
                `);
            }
        });
    });
});