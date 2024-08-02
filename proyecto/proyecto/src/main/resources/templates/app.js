document.getElementById('dueñoForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const nombre = document.getElementById('nombreDueño').value;
    const telefono = document.getElementById('telefono').value;
    const email = document.getElementById('email').value;

    fetch('/api/dueños', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ nombre, telefono, email })
    })
        .then(response => response.json())
        .then(data => {
            alert('Dueño registrado con éxito');
            document.getElementById('dueñoForm').reset();
        })
        .catch(error => console.error('Error:', error));
});

document.getElementById('mascotaForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const nombre = document.getElementById('nombreMascota').value;
    const especie = document.getElementById('especie').value;
    const raza = document.getElementById('raza').value;
    const fechaNacimiento = document.getElementById('fechaNacimiento').value;
    const dueñoId = document.getElementById('dueñoId').value;

    fetch('/api/mascotas', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ nombre, especie, raza, fechaNacimiento, dueño: { id: dueñoId } })
    })
        .then(response => response.json())
        .then(data => {
            alert('Mascota registrada con éxito');
            fetchMascotas();
            document.getElementById('mascotaForm').reset();
        })
        .catch(error => console.error('Error:', error));
});

function fetchMascotas() {
    fetch('/api/mascotas')
        .then(response => response.json())
        .then(data => {
            const mascotaList = document.getElementById('mascotaList');
            mascotaList.innerHTML = '';
            data.forEach(mascota => {
                const listItem = document.createElement('li');
                listItem.textContent = `Nombre: ${mascota.nombre}, Especie: ${mascota.especie}, Raza: ${mascota.raza}`;
                mascotaList.appendChild(listItem);
            });
        })
        .catch(error => console.error('Error:', error));
}

document.addEventListener('DOMContentLoaded', fetchMascotas);
