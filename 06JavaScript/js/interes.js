/*  
vamos a realizar una funcion que se encargue de validar la entrada
de numeros por medio de una expresion regular
*/ 

function validarn(e){
    var teclado = (document.all)? e.keyCode : e.which;
    if(teclado == 8) return true;
    var patron = /[0-9\d .]/;
    var codigo = String.fromCharCode(teclado);
    return patron.test(codigo);
}