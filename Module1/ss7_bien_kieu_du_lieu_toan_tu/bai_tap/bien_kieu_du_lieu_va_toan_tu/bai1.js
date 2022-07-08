let inputLy= prompt("Ly");
let inputHoa= prompt("Hoa");
let inputSinh= prompt("Sinh");
let Ly=parseInt(inputLy);
let Hoa=parseInt(inputHoa);
let Sinh=parseInt(inputSinh);
let Trungbinh= (Ly+Hoa+Sinh)/3;
let Tong= Ly+Hoa+Sinh;
document.write("Diem trung binh=" +Trungbinh);
document.write('<br/>')
document.write("Diem tong=" +Tong);