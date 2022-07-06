function cong() {
    let a = parseInt(document.getElementById("Number1").value);
    let b = parseInt(document.getElementById("Number2").value);
    let kq = a + b;
    document.getElementById("Ket_qua").innerHTML = kq;

}

function tru() {
    let a = parseInt(document.getElementById("Number1").value);
    let b = parseInt(document.getElementById("Number2").value);
    let kq = a - b;
    document.getElementById("Ket_qua").innerHTML = kq;

}
function nhan() {
    let a = parseInt(document.getElementById("Number1").value);
    let b = parseInt(document.getElementById("Number2").value);
    let kq = a * b;
    document.getElementById("Ket_qua").innerHTML = kq;

}
function chia() {
    let a = parseInt(document.getElementById("Number1").value);
    let b = parseInt(document.getElementById("Number2").value);
    let kq = a / b;
    document.getElementById("Ket_qua").innerHTML = kq;

}

