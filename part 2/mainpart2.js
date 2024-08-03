        // THIS IS AN ARRAY OF THE IMAGE FILE 
        const images = [
            'pic1.jpg',
            'pic2.jpg',
            'pic3.jpg',
            'pic4.jpg',
            'pic5.jpg'
        ];

        const thumbBar = document.querySelector('.thumb-bar');
        const displayedImg = document.querySelector('.displayed-img');
        const overlay = document.querySelector('.overlay');
        const btn = document.querySelector('button');

        // THIS IS A LOOP OF THE IMAGES STARTING AT 1
        for (let i = 1; i <= images.length; i++) {
            const newImage = document.createElement('img');
            newImage.setAttribute('src', 'images/' + images[i - 1]);
            newImage.setAttribute('alt', 'Thumbnail ' + i);
            thumbBar.appendChild(newImage);

            
            newImage.addEventListener('click', function(event) {
                displayedImg.setAttribute('src', event.target.getAttribute('src'));
                displayedImg.setAttribute('alt', event.target.getAttribute('alt'));
            });
        }

        // THIS IS A HANDLER FOR THE DARKEN AND LIGHTEN BUTTON
        btn.addEventListener('click', function() {
            const btnClass = btn.getAttribute('class');
            if (btnClass === 'dark') {
                btn.setAttribute('class', 'light');
                btn.textContent = 'Lighten';
                overlay.style.backgroundColor = 'rgba(0,0,0,0.5)';
            } else {
                btn.setAttribute('class', 'dark');
                btn.textContent = 'Darken';
                overlay.style.backgroundColor = 'rgba(0,0,0,0)';
            }
        });