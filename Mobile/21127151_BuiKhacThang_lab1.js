
/////////////Tuần 01
///DATA 01
/* let MarkMASS = 78;
let JohnMASS = 92;
let MarkHeight = 1.69;
let JohnHeight = 1.95;

let MarkBMI = MarkMASS / (MarkHeight**2);
let JohnBMI = JohnMASS / (JohnHeight**2);

console.log("----DATA 1:");

console.log("BMI của Mark: ",MarkBMI);
console.log("BMI của John:",JohnBMI);

if(MarkBMI > JohnBMI) {
    console.log(`Mark's BMI(${MarkBMI.toFixed(1)}) is higher than John's (${JohnBMI.toFixed(1)})!`);
    
}else {
    console.log(`John's BMI(${JohnBMI.toFixed(1)}) is higher than Mark's (${MarkBMI.toFixed(1)})!`);
}


///DATA 02
let MarkMASS1 = 95;
let JohnMASS1 = 85;
let MarkHeight1 = 1.88;
let JohnHeight1 = 1.76;

let MarkBMI1 = MarkMASS1 / (MarkHeight1**2);
let JohnBMI1 = JohnMASS1 / (JohnHeight1**2);

console.log("----DATA 2:");

console.log("BMI của Mark: ",MarkBMI1);
console.log("BMI của John:",JohnBMI1);

if(MarkBMI1 > JohnBMI1) {
    console.log(`Mark's BMI(${MarkBMI1.toFixed(1)}) is higher than John's (${JohnBMI1.toFixed(1)})!`);
    
}else {
    console.log(`John's BMI(${JohnBMI1.toFixed(1)}) is higher than Mark's (${MarkBMI1.toFixed(1)})!`);
}
 */

//////Coding challenge #3
/* const DolphinsScore = [88,91,150];
const KoalasScore = [88,91,150];

const DolphinsAVG = (DolphinsScore[0]+DolphinsScore[1]+DolphinsScore[2])/3;
const KoalasAVG = (KoalasScore[0]+KoalasScore[1]+KoalasScore[2])/3;

console.log("Trung bình của Dolphins: ",DolphinsAVG.toFixed(1));
console.log("Trung bình của Koala: ",KoalasAVG.toFixed(1));
if (DolphinsAVG >= 100 || KoalasAVG >=100 ) {
    if(DolphinsAVG >= KoalasAVG) {
        if(DolphinsAVG > KoalasAVG)
        console.log("Trung bình của Dolphins thắng");
        if(((DolphinsAVG >= 100) && (KoalasAVG >= 100)) && (DolphinsAVG == KoalasAVG))
            console.log("Trung bình của Dolphins hòa Koala");
    }else{
        console.log("Trung bình của Koala thắng");
    }
    
}else{
    console.log("Không đội nào thắng vì không đạt tối thiểu 100 điểm");
    
} */

//////Coding challenge #4
/* const tienBill = 275;
const tienTip = tienBill>=50 && tienBill <=300 ? tienBill*0.15 : tienBill*0.20;
console.log("Tiền tips là: ",tienTip);
console.log(`The bill was ${tienBill}, the tip was ${tienTip} and the total value ${tienBill+tienTip}`); */

//////Coding challenge #5
/* const calcAVG = (score1,score2,score3) => (score1 + score2 + score3)/3
const DolphinsAVG = calcAVG(85,54,41);
const KoalasAVG = calcAVG(23,34,27);

console.log("Trung bình dolphins: ",DolphinsAVG.toFixed(1));
console.log("Trung bình koalas: ",KoalasAVG.toFixed(1));

const checkWinner = (DolphinsAVG,KoalasAVG) => {
    if (DolphinsAVG >= 2 * KoalasAVG) {
        console.log(`Dolphins win (${DolphinsAVG.toFixed(1)} vs.${KoalasAVG.toFixed(1)})`);
        
    } else if (KoalasAVG >= 2 * DolphinsAVG){
        console.log(`KoalasAVG win (${KoalasAVG.toFixed(1)} vs.${DolphinsAVG.toFixed(1)})`);
    }else{
        console.log(`No one win (${KoalasAVG.toFixed(1)} vs ${DolphinsAVG.toFixed(1)})`);
    }
}
checkWinner(DolphinsAVG,KoalasAVG); */



//////Coding challenge #6
/* const calcTip = billvalue1 =>{
    return billValue >= 50 && billValue <= 300 ? billValue * 0.15 : billValue * 0.20;
}
const billValue = 100;
const tips1 = calcTip(billValue);
console.log(`Giá trị hóa đơn: ${billValue}`);
console.log(`Tiền tip: ${tips1}`);

const mangBill = [125,555,44];
const mangTip = mangBill.map(calcTip);
console.log("Mảng bills: ",mangBill);
console.log("Mảng tips: ",mangTip);

const mangTong = mangBill.map((bill,index) => bill+ mangTip[index]);
console.log("Mảng tổng : ",mangTong); */


//////Coding challenge #7
/* const Mark = {
    fullName: "Mark Miller",
    mass: 78,
    height: 1.69,
    calcBMI: function(){
        this.bmi = this.mass / (this.height ** 2);
        return this.bmi;
    }
};

const john = {
    fullName: 'John Smith',
    mass: 92, 
    height: 1.95,    
    calcBMI: function(){
        this.bmi = this.mass / (this.height ** 2);
        return this.bmi;
    }
};
const markBMI = Mark.calcBMI();
const johnBMI = john.calcBMI();
console.log(markBMI);
console.log(johnBMI);

if (markBMI > johnBMI) {
    console.log(`${Mark.fullName}'s BMI (${markBMI.toFixed(1)}) is higher than ${john.fullName}'s (${johnBMI.toFixed(1)})!`);
} else if (johnBMI > markBMI) {
    console.log(`${john.fullName}'s BMI (${johnBMI.toFixed(1)}) is higher than ${Mark.fullName}'s (${markBMI.toFixed(1)})!`);
} else {
    console.log(`Both ${Mark.fullName} and ${john.fullName} have the same BMI (${markBMI.toFixed(1)})!`);
}
 */

//////Coding challenge #8
/* const calcTip = billValue => {
    return billValue >= 50 && billValue <= 300 ? billValue * 0.15 : billValue * 0.20;
};
const bills = [22, 295, 176, 440, 37, 105, 10, 1100, 86, 52];
const tips = [];
const totals = [];
for (let index = 0; index < bills.length; index++) {
    const bill = bills[index];
    const tip = calcTip(bill);
    const total = bill + tip;
    tips.push(tip);
    totals.push(total);
    
}
console.log("Bills:",bills );
console.log("Tips:",tips );
console.log("Totals:",totals );


const calcAverage = arr => {
    let sum = 0 ;
    for (let index = 0; index < arr.length; index++) {
        sum += arr[index];
        
    }
    const trungbinh = sum/ arr.length;
    return trungbinh;
}

const mangDaTinh = [26.4, 354.0, 202.4, 528.0, 44.4, 120.75, 12.0, 1320.0, 103.2, 62.4];
console.log("Trung bình mảng đã tính là: ",calcAverage(mangDaTinh).toFixed(1));
 */

//////Coding challenge #9
const duDoan = arr => {
    let duDoanThoiTiet = [];
    for (let index = 0; index < arr.length; index++) {
       duDoanThoiTiet.push(`${arr[index]}oC in ${index + 1} days`);
        
    }
    const duDoanThoiTiet1 = duDoanThoiTiet.join('...');
    console.log(duDoanThoiTiet1);
    
}
const data1 = [12, 5, -5, 0, 4];
duDoan(data1);