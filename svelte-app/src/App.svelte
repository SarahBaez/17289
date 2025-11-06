<script>
	import Hijo from './Hijo.svelte';
	// export let name;
	export let nombre;

	let contador = 0;
	function incrementar() {
		contador += 1;
	}

	function saludar() {
		alert(nombre ? nombre : "Hola Nulo");
	}
</script>

<main>
	<!-- <p>Hola {name}!</p> -->
	<!-- <p>Visit the <a href="https://svelte.dev/tutorial">Svelte tutorial</a> to learn how to build Svelte apps.</p> -->
	 <h1>Contar: {contador}</h1>
	 <button on:click={incrementar}>Contar</button>
	 <Hijo texto="Guardar" color="green"></Hijo>
	<Hijo texto="Borrar" color="red"></Hijo>
	<input placeholder="Escribe tu nombre" bind:value={nombre}/>
	<br/>
	<button on:click={saludar}>saludar</button>
</main>

<style>
	main {
		text-align: center;
		padding: 1em;
		max-width: 240px;
		margin: 0 auto;
	}

	h1 {
		color: #ff3e00;
		text-transform: uppercase;
		font-size: 4em;
		font-weight: 100;
	}

	@media (min-width: 640px) {
		main {
			max-width: none;
		}
	}
</style>