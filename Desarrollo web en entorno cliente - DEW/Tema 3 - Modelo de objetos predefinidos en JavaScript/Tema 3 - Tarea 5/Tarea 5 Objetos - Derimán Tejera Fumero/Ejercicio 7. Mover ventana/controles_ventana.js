let nueva_ventana;

function abrir_nueva_ventana() {
    nueva_ventana = window.open("", "", "width=400, height=400");
}

function mover_ventana() {
    if (nueva_ventana) {
        nueva_ventana.moveBy(10, 10);
    }
}

function mover_pos() {
    if (nueva_ventana) {
        nueva_ventana.moveTo(100, 100);
    }
}

function aumentar_width() {
    if (nueva_ventana) {
        nueva_ventana.resizeBy(10, 0);
    }
}

function aumentar_height() {
    if (nueva_ventana) {
        nueva_ventana.resizeBy(0, 10);
    }
}

function anadir_scroll() {
    if (nueva_ventana) {
        nueva_ventana.document.body.style.overflow = 'scroll';
    }
}
//Derimán Tejera Fumero 2DAW Semi B