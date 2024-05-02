
	const imageInput = document.getElementById('imageInput');
	const previewImage = document.getElementById('previewImage');

	imageInput.addEventListener('change', function() {
	  const file = this.files[0];
	  const reader = new FileReader();

	  reader.onload = function(e) {
	    previewImage.src = e.target.result;
	  }

	  reader.readAsDataURL(file);
	});


	