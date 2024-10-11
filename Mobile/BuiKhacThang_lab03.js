// Bài 27
/*  function getUniqueElement(array) {
    return [... new Set(array)];
}
const mangBanDau = [0,1,2,3,4,1,5,6,2,3];
const mangRiengBiet = getUniqueElement(mangBanDau);
console.log("Mang ban dau: " + mangBanDau);
console.log("Mang riêng biệt: " + mangRiengBiet);  */

//Bài 28
 function kiemTraNguyenTo(number) {
    if(number < 2 ) return false;
    for (let index = 2; index < Math.sqrt(number); index++){
        if(number % index === 0 ) return false;
}
return true;
}
function trungBinh100SoNguyenTo(){
    const mangNguyenTo = [];
    let number = 2;
    while(mangNguyenTo.length < 100 ){
        if(kiemTraNguyenTo(number)) {
            mangNguyenTo.push(number);
        }
        number++;
    }
    const sum = mangNguyenTo.reduce((total,mangNguyenTo) => total + mangNguyenTo, 0);
    return {
        primes: mangNguyenTo,
        sum: sum
    };

}
const result = trungBinh100SoNguyenTo();
console.log("Tổng của 100 số nguyên tố đầu tiên là: ", result.sum); 


//Bài 29
/*  function kiemTraNguyenTo(number) {
    if(number < 2 ) return false;
    for (let index = 2; index < Math.sqrt(number); index++){
        if(number % index === 0 ) return false;
}
return true;
}
function lay100SoNguyenTo(){
    const mangNguyenTo = [];
    let number = 2;
    while(mangNguyenTo.length < 100 ){
        if(kiemTraNguyenTo(number)) {
            mangNguyenTo.push(number);
        }
        number++;
    }
   return mangNguyenTo;

}
function tinhKhoangCach() {
    const primes = lay100SoNguyenTo();
    const khoangCach = [];
    for(let i = 1; i <primes.length; i++){
        khoangCach.push(primes[i] - primes[i-1]);
    }
    console.log("Khoangr cách của 100 số nguyên tố đầu tiên là: ",khoangCach);
    
}
tinhKhoangCach(); */

//Bài 30
/* function congHaiSo(number1, number2) {
    let result = '';
    let carry = 0;
    let i = number1.length -1;
    let j = number2.length -1;

    while(i >= 0 ||  j>=0 || carry){
        let so1 = i >= 0 ? parseInt(number1[i]) : 0;
        let so2 = j>= 0 ? parseInt(number2[j]) : 0;
        let sum = so1 + so2 + carry;

        carry = Math.floor(sum / 10); 
        result = (sum % 10) + result; 
        i--; 
        j--;
    }
    return result;
}
const number1 = "123456789";
const number2 = "987650";
const sum = congHaiSo(number1, number2);
console.log("Kết quả cộng hai số là:", sum); */

//Bài 31
/* function demTu(chuoi) {
    const word = chuoi.trim().split(/\s+/);
    return word[0] === ""? 0 : word.length;
    
}
console.log("Số từ trong đoạn văn bản là:", demTu("KKhac Thang")); */

//Bài 32
/* function vietHoaChuDau(text) {
    return text
        .split(' ')
        .map(word => word.charAt(0).toUpperCase()+ word.slice(1))
        .join(' ')
    
}
const text = "bui khac thang";

console.log("Kết quả:", vietHoaChuDau(text)); */

//Bài 33
/* function tinhTongTuChuoi(text) {
    const numbers = text.split(',').map(Number);
    const sum = numbers.reduce((total, num) => total + num, 0);
    return sum;
}
const text = "1,2,3,4";
const result = tinhTongTuChuoi(text);
console.log("Tổng các số là:", result); */

//Bài 34
/* function tachCacTu(text) {
    const mangChuaTu  = text.split(/\s+/);;
    return mangChuaTu; 
}
const text = "Bui Khac Thang";
console.log("Mảng sau khi tách từ: ", tachCacTu(text));
 */

//Bài 35
/* function chuyenDoiSangMang(text) {
    return text
        .trim()                  
        .split('\n')            
        .map(row => row.split(',')); 
}
const text = `ten, tuoi, lop
Thang,21,17CTT`;
const array =  chuyenDoiSangMang(text);
console.log(array); */

//Bài 36
/* function doiSangMang(text) {
    return text.split('');
}
const text = "Bui Khac THang";
const arr = doiSangMang(text);
console.log(arr); */

//Bài 37
/* function doiSangMaASCII(text) {
    return text.split('').map(char => char.charCodeAt(0));  
}
const text = "BuiKhacThang";
const arr = doiSangMaASCII(text);
console.log(arr);
 */

//Bài 38
/* function asciiSangChuoi(asciiArray) {
    return asciiArray.map(code => String.fromCharCode(code)).join(''); 
}
const asciiArray = [72, 101, 108, 108, 111];
const text = asciiSangChuoi(asciiArray);
console.log(text);

 */

//Bài 39
/* function maHoa(text, shift) {
    function shiftChar(char, shift) {
        const base = char.charCodeAt(0);
        if (char >= 'a' && char <= 'z') {
            return String.fromCharCode(((base - 97 + shift) % 26 + 26) % 26 + 97);
        } else if (char >= 'A' && char <= 'Z') {
            return String.fromCharCode(((base - 65 + shift) % 26 + 26) % 26 + 65);
        } else {
            return char;
        }
    }
    return text.split('').map(char => shiftChar(char, shift)).join('');
}
const plaintext = "Bùi Khắc Thắng";
const shift = 3;
const encrypted = maHoa(plaintext, shift);
const decrypted = maHoa(encrypted, -shift); 
console.log("Decrypted:", decrypted);
console.log("Encrypted:", encrypted);
 */