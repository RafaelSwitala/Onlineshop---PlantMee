document.addEventListener("DOMContentLoaded", function() {
    const data = { index: 'active', title: 'Shop' };

    render(data).catch(err => {
        console.error("Error rendering templates:", err);
    });
});

const queryAll = query => Array.from(document.querySelectorAll(query));

const render = async (data) => {
    const templates = queryAll('[type="text/x-handlebars-template"]');

    for (const source of templates) {
        await loadPartials(source).catch(err => {
            console.error("Error loading partials:", err);
        });
        if (typeof Handlebars !== 'undefined') {
            const template = Handlebars.compile(source.innerHTML);
            const target = source.parentElement;
            if (target.lastElementChild)
                target.lastElementChild.remove();
            target.insertAdjacentHTML('beforeend', template(data));
        } else {
            console.error("Handlebars is not defined");
        }
    }
};

async function loadPartials(code) {
    const partialNames = code.innerText.match(/(?<={{(#>|>)).+?(?=\s)/g);
    if (partialNames) {
        for (let name of partialNames) {
            name = name.trim();
            const fileName = `partials/${name}.html`;
            try {
                const response = await fetch(fileName);
                if (!response.ok) {
                    throw new Error('Failed to fetch partial: ' + fileName);
                }
                const partialCode = await response.text();
                if (typeof Handlebars !== 'undefined') {
                    Handlebars.registerPartial(name, partialCode);
                } else {
                    console.error("Handlebars is not defined");
                }
            } catch (error) {
                console.error('Failed to load partial:', error);
                throw new Error('Failed to load partial: ' + fileName);
            }
        }
    }
}
