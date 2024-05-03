/*
Queremos hacer una aplicación en JavaScript para gestionar edificios con la información de la situación del edificio y de los propietarios de cada piso. Para ello queremos almacenar la siguiente información de cada edificio:
•	calle. 
•	número. 
•	código postal.
•	plantas del edificio (dentro de cada planta tendremos un número de puertas y para cada puerta almacenaremos el nombre del propietario).

Se pide:
Crear un objeto que nos permita instanciar edificios. Cada vez que instanciemos un edificio le pasaremos la calle, número y código postal como parámetros. Se pide además crear los siguientes métodos para el objeto Edificio:
•	agregarPlantasYPuertas(numplantas, puertas) // Se le pasa el número de plantas que queremos crear en el piso y el número de puertas por planta. Cada vez que se llame a este método, añadirá el número de plantas y puertas indicadas en los parámetros, a las que ya están creadas en el edificio.
•	modificarNumero (numero) // Se le pasa el nuevo número del edificio para que lo actualice.
•	modificarCalle(calle) // Se le pasa el nuevo nombre de la calle para que lo actualice.
•	modificarCodigoPostal(codigo) // Se le pasa el nuevo número de código postal del edificio.
•	imprimeCalle // Devuelve el nombre de la calle del edificio.
•	imprmeNumero // Devuelve el número del edificio.
•	imprimeCodigoPostal // Devuelve el código postal del edificio.
•	agregarPropietario(nombre, planta, puerta) // Se le pasa un nombre de propietario, un número de planta y un número de puerta y lo asignará como propietario de ese piso.
•	imprimePlantas // Recorrerá el edificio e imprimirá todos los propietarios de cada puerta.

Cada vez que se crea un edificio que muestre automáticamente un mensaje del estilo:
•	construido nuevo edificio en calle: xxxxxx, nº: xx, CP: xxxxx.
Cada vez que se añada un propietario a un piso de un edificio que muestre un mensaje del estilo:
•	xxxxxxxx es ahora el propietario de la puerta x de la planta x.

Aquí se muestra un ejemplo de lo que tendría que mostrar la aplicación:
Trabajando con objetos JavaScript:

Instanciamos 3 objetos edificioA, edificioB y edificioC con estos datos:
•	Construido nuevo edificio en calle: García Prieto, n°: 58, CP: 15706.
•	Construido nuevo edificio en calle: Camino Caneiró, n°: 29, CP: 32004.
•	Construido nuevo edificio en calle: San Clemente, n°: s/n, CP: 15705.

•	El código postal del edificio A es: 15706.
•	La calle del edificio C es: San Clemente.
•	El edificio B está situado en la calle Camino Caneiro número 29.

Agregamos 2 plantas y 3 puertas por planta al edificioA...
Agregamos 4 propietarios al edificio A...

•	José Antonio López es ahora el propietario de la puerta 1 de la planta 1.
•	Luisa Martínez es ahora el propietario de la puerta 2 de la planta 1.
•	Marta Castellón es ahora el propietario de la puerta 3 de la planta 1
•	Antonio Pereira es ahora el propietario de la puerta 2 de la planta 2.

Listado de propietarios del edificio calle García Prieto número 58
•	Propietario del piso 1 de la planta 1: José Antonio López.
•	Propietario del piso 2 de la planta 1: Luisa Martínez.
•	Propietario del piso 3 de la planta 1: Marta Castellón.
•	Propietario del piso 1 de la planta 2:
•	Propietario del piso 2 de la planta 2: Antonio Pereira.
•	Propietario del piso 3 de la planta 2:

Agregamos 1 planta más al edificioA...
Agregamos 1 propietario más al edificio A planta 3, puerta 2...
•	Pedro Meijide es ahora el propietario de la puerta 2 de la planta 3.

Listado de propietarios del edificio calle García Prieto número 58
Propietario del piso 1 de la planta 1: José Antonio López.
Propietario del piso 2 de la planta 1: Luisa Martínez.
Propietario del piso 3 de la planta 1: Marta Castellón.
Propietario del piso 1 de la planta 2:

Propietario del piso 2 de la planta 2: Antonio Pereira.
Propietario del piso 3 de la planta 2:
Propietario del piso 1 de la planta 3:
Propietario del piso 2 de la planta 3: Pedro Meijide.
*/

//Creamos un objeto llamado Edificio con el que gestionaremos todas las características que nos piden en el ejercicio para representar a los edificios.
//A este objeto le pasaremos como parámetros: el nombre de la calle, el número y el código postal.
//También crearemos una matriz vacía que llamaremos plantas para almacenar la ubicación de los pisos que conforman el edificio.
function Edificio(calle, numero, codigoPostal) {
    this.calle = calle;
    this.numero = numero;
    this.codigoPostal = codigoPostal;
    this.plantas = [];
}

//Método con el que agregaremos las plantas y las puertas.
//Definimos el método asociado con la función constructora Edificio por lo que cualquier instancia de Edificio tendrá acceso a este método.
//Los parámetros que recibe el método serán numPlantas que es el número de plantas que se añadirán y puertas que es el número de puertas que se añadirán por cada planta.
Edificio.prototype.agregarPlantasYPuertas = function (numPlantas, puertas) {
    for (let i = 0; i < numPlantas; i++) {
        //Con este bucle añadiremos plantas al edificio.
        const planta = [];

        //En este bucle añadiremos puertas a cada planta. Esto lo hacemos añadiendo una cadena vacía que equivaldrá a una puerta sin propietario.
        for (let j = 0; j < puertas; j++) {
            planta.push("");
        }

        //Añadiremos la planta recién creada a la lista de plantas del edificio.
        this.plantas.push(planta);
    }
};

//Método para modificar el número de calle del edificio
Edificio.prototype.modificarNumero = function (numero) {
    //Modificamos el número actual del objeto Edificio con el nuevo valor.
    this.numero = numero;
};

//Método para modificar la calle del edificio
Edificio.prototype.modificarCalle = function (calle) {
    //Modificamos el nombre actual del objeto Edificio con el nuevo nombre para la calle.
    this.calle = calle;
};

//Método para modificar el código postal del edificio
Edificio.prototype.modificarCodigoPostal = function (codigo) {
    //Modificamos el número actual del código postal del Edificio con el nuevo valor para el código postal.
    this.codigoPostal = codigo;
};

//Método para conseguir el nombre de la calle del edificio
Edificio.prototype.imprimeCalle = function () {
    //Devolverá el nombre de la calle.
    return this.calle;
};

//Método para conseguir el número del edificio
Edificio.prototype.imprimeNumero = function () {
    //Devolverá el número de la calle.
    return this.numero;
};

//Método para conseguir el código postal del edificio
Edificio.prototype.imprimeCodigoPostal = function () {
    //Devolverá el número del código postal del edificio.
    return this.codigoPostal;
};

//Método para agregar un nuevo propietario a una puerta. Se le pasarán los tres parámetros indicados entre ( ).
Edificio.prototype.agregarPropietario = function (nombre, planta, puerta) {

    //Comprobaremos si los número de planta y puerta son válidos para el edificio. Si no es válida mostrará un mensaje.
    if (planta <= this.plantas.length && puerta <= this.plantas[planta - 1].length) {
        this.plantas[planta - 1][puerta - 1] = nombre;
    } else {
        console.log("Planta o puerta no válida.");
    }
};

//Método para conseguir todos los nombres y ubicaciones de todos los propietarios de un piso en el edificio.
Edificio.prototype.imprimePlantas = function () {

    //Creamos un array vacío para almacenar los nombres de los propietario.
    const propietarios = [];

    //Bucle que recorrerá todas las plantas del edificio.
    for (let i = 0; i < this.plantas.length; i++) {
        //Bucle que recorrerá todas las puertas de la planta.
        for (let j = 0; j < this.plantas[i].length; j++) {

            //Obtenemos el nombre del propietario de la puerta y planta actual del bucle.
            const propietario = this.plantas[i][j];

            //Verificamos que exite un propietario y que no se trata de un piso sin propietario. En el caso de tenerlo mostrará su nombre (if) y si no lo tiene (else) lo dejará vacío.
            if (propietario !== "") {
                propietarios.push(`Propietario del piso ${j + 1} de la planta ${i + 1}: ${propietario}.`);
            } else {
                propietarios.push(`Propietario del piso ${j + 1} de la planta ${i + 1}:`);
            }
        }
    }
    //Devolvemos el array con la lista de propietarios obtenida y su ubicación dentro del edificio.
    return propietarios;
};

//Función para mostrar mensajes por pantalla
function mostrarMensaje(mensaje) {
    //Obtenemos la referencia al elemento mostar_pantalla
    const mostar_pantalla_ch = document.getElementById("mostar_pantalla");
    //Creamos un elemento de párrafo que utilizaremos para mostar el mensaje.
    const p = document.createElement("p");
    //Utilizamos inner para insertar el mensaje dentro del párrafo. Con esto podremos interpretar html dentro de la cadena.
    p.innerHTML = mensaje;
    //Añadiremos el párrafo como hijo del elemento mostar_pantalla_ch para poder insertar el elemento dentro de la id mostar_pantalla.
    mostar_pantalla_ch.appendChild(p);
}

//Función que utilizaremos para crear un salto de línea de forma fácil donde lo necesitemos para organizar todo el texto resultante de la aplicación.
function saltoDeLinea() {

    //Creamos el elemento html de salto de linea y lo asignamos a const br.
    const br = document.createElement("br");
    //Obtenemos la referencia id de mostrar_pantalla.
    const mostar_pantalla_ch = document.getElementById("mostar_pantalla");
    //Añadimos el elemento br ya creado como hijo del elemento con id mostrar_pantalla, asi conseguimos insertar br en el documetno html donde esté la id mostrar_pantalla.
    mostar_pantalla_ch.appendChild(br);
}

//En esta sección comenzaremos la aplicación propiamente:
//Utilizaremos <strong> para hacer mas llamativo mediante letras en negrita el texto que indicará cuándo y qué se hace internamente en el código.
mostrarMensaje(`<strong>Instanciamos 3 objetos: edificioA, edificioB y edificioC con los siguintes datos:</strong`);

//Creamos las instancias para los edificios A, B y C.  Enviamos al constructoor los tres argumentos que solicita: calle, número y código postal.
const edificioA = new Edificio("García Prieto", 58, "15706");
const edificioB = new Edificio("Camino Caneiró", 29, "32004");
const edificioC = new Edificio("San Clemente", "s/n", "15705");

//Utilizaremos la función mostrarMensaje para mostar por pantalla al usuario. Mostraremos con texto intercalado con los datos solicitados de cada edificio según corresponda. 
mostrarMensaje(`Construido nuevo edificio en calle: ${edificioA.imprimeCalle()}, nº: ${edificioA.imprimeNumero()}, CP: ${edificioA.imprimeCodigoPostal()}.`);
mostrarMensaje(`Construido nuevo edificio en calle: ${edificioB.imprimeCalle()}, nº: ${edificioB.imprimeNumero()}, CP: ${edificioB.imprimeCodigoPostal()}.`);
mostrarMensaje(`Construido nuevo edificio en calle: ${edificioC.imprimeCalle()}, nº: ${edificioC.imprimeNumero()}, CP: ${edificioC.imprimeCodigoPostal()}.`);

//Llamamos a la función salto de línea para introducirlo y que visualmente sea mas organizado de cara al usuario.
saltoDeLinea();

//Volvemos a utilizar la función mostrarMensaje para exponer al usuario los datos que solicita el ejercicio. Para ello se llamará a las funciones ya creadas para obtenerlos de Edificio.
mostrarMensaje(`El código postal del edificio A es: ${edificioA.imprimeCodigoPostal()}.`);
mostrarMensaje(`La calle del edificio C es: ${edificioC.imprimeCalle()}.`);
mostrarMensaje(`El edificio B está situado en la calle ${edificioB.imprimeCalle()} número ${edificioB.imprimeNumero()}.`);

saltoDeLinea();

mostrarMensaje(`<strong>Agregamos 2 plantas y 3 puertas por planta al edifico A.</strong`);
//Llamamos al método agregarPlantasYPuertas sobre el objeto edificioA para añadir 2 plantas y 3 puertas.
edificioA.agregarPlantasYPuertas(2, 3);

saltoDeLinea();

mostrarMensaje(`<strong>Agregamos 4 propietarios al edifico A</strong>`);

mostrarMensaje(`<strong>Jose Antonio Lopez es ahora el propietario de la puerta 1 de la planta 1.</strong>`);
mostrarMensaje(`<strong>Luisa Martinez es ahora el propietario de la puerta 2 de la planta 1.</strong>`);
mostrarMensaje(`<strong>Marta Castellón es ahora el propietario de la puerta 3 de la planta 1.</strong>`);
mostrarMensaje(`<strong>Antonio Pereira es ahora el propietario de la puerta 1 de la planta 1.</strong>`);

saltoDeLinea();

//Asignamos los nombres de los propietarios a los diferentes pisos del edificio tal y como pide el enunciado.
edificioA.agregarPropietario("José Antonio López", 1, 1);
edificioA.agregarPropietario("Luisa Martínez", 1, 2);
edificioA.agregarPropietario("Marta Castellón", 1, 3);
edificioA.agregarPropietario("Antonio Pereira", 2, 2);

//Mostramos por pantalla mediante un bucle el listado de propietarios del edificio A.
mostrarMensaje(`Listado de propietarios del edificio calle ${edificioA.imprimeCalle()} número ${edificioA.imprimeNumero()}`);
//Almacenamos la lista de propietarios.
const propietariosEdificioA = edificioA.imprimePlantas();
//Llamamos a la función mostrarMensaje mediante un bucle for of que recorrerá los iterables del array para mostar al usuario todos los propietarios almacenados previamente.
for (const propietario of propietariosEdificioA) {
    mostrarMensaje(propietario);
}

saltoDeLinea();

mostrarMensaje(`<strong>Agregamos 1 planta más al edifico A.</strong>`);

//Llamamos al método agregarPlantasYPuertas sobre el objeto edificioA para añadir 1 planta y 3 puertas.
edificioA.agregarPlantasYPuertas(1, 3);

mostrarMensaje(`<strong>Agregamos 1 propietario más al edifico A planta 3, puerta 2.</strong>`);
//Llamamos al método agregarPropietario sobre el objeto edificioA para añadir un nombre de propietario. Los parámetros entre () son: nombre del propietario, planta 3, puerta 2.
edificioA.agregarPropietario("Pedro Meijide", 3, 2);

saltoDeLinea();

//Encabezado del listado que se va a mostrar posteriormente con el bucle.
mostrarMensaje(`Listado de propietarios del edificio calle ${edificioA.imprimeCalle()} número ${edificioA.imprimeNumero()}`);
//Volvemos a mostrar el listado de todos los pisos que existen en el edificioA, esto se hace para mostar los cambios hechos anteriormente, añadiendo mas plantas y puertas y el nombre de un propietario.
//Almacenamos la lista de propietarios en const propietariosEdificioA2.
const propietariosEdificioA2 = edificioA.imprimePlantas();
//Llamamos a la función mostrarMensaje mediante un bucle for of que recorrerá los iterables del array para mostar al usuario todos los propietarios almacenados previamente.
for (const propietario of propietariosEdificioA2) {
    mostrarMensaje(propietario);
}
//Derimán Tejera Fumero 2DAW Semi B