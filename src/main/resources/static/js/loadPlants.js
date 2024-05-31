function loadPlantsData() {
    fetch('data/plants.csv')
        .then(response => response.text())
        .then(csvText => {
            const plantsData = Papa.parse(csvText, {
                header: true,
                dynamicTyping: true
            }).data;

            displayPlants(plantsData);
            displayCategories(plantsData);
        })
        .catch(error => console.error('Error loading the CSV file:', error));
}



// function displayCategories(plants) {
//     const categoriesSet = new Set();
//     plants.forEach(plant => {
//         categoriesSet.add(plant.Kategorie);
//     });

//     const categoriesArray = Array.from(categoriesSet);

//     const categoriesDiv = document.querySelector('.main-page__categories');
//     categoriesDiv.innerHTML = 'Kategorien';

//     const categoriesList = document.createElement('div');
//     categoriesArray.forEach(category => {
//         const listItem = document.createElement('button');
//         listItem.textContent = category;
//         listItem.classList.add('category-button');
//         listItem.addEventListener('click', () => filterPlantsByCategory(plants, category));
//         categoriesList.appendChild(listItem);
//     });

//     categoriesDiv.appendChild(categoriesList);
// }

// function displayPlants(plants) {
//     const container = document.getElementById('card-container');

//     container.innerHTML = '';

//     plants.forEach(plant => {
//         const card = document.createElement('div');
//         card.className = 'card-item';

//         const nameDiv = document.createElement('div');
//         nameDiv.className = 'card-item__name';
//         nameDiv.textContent = plant.Name;

//         const imageDiv = document.createElement('div');
//         imageDiv.className = 'card-item__image';
//         const img = document.createElement('img');
//         img.src = plant.URL;
//         img.alt = plant.Name;
//         imageDiv.appendChild(img);

//         const priceDiv = document.createElement('div');
//         priceDiv.className = 'card-item__price';
//         priceDiv.textContent = `${plant.Preis}€`;

//         const button = document.createElement('button');
//         button.className = 'card-item__warenkorb-button';
//         button.textContent = 'Zum Warenkorb hinzufügen';

//         card.appendChild(nameDiv);
//         card.appendChild(imageDiv);
//         card.appendChild(priceDiv);
//         card.appendChild(button);

//         container.appendChild(card);
//     });
// }


function filterPlantsByCategory(plants, category) {
    const filteredPlants = plants.filter(plant => plant.Kategorie === category);
    displayPlants(filteredPlants);
}

document.addEventListener("DOMContentLoaded", loadPlantsData);
