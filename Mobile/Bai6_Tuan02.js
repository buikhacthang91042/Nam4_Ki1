function Car(make, speed) {
    this.make = make;
    this.speed = speed; 
}
Car.prototype.accelerate = function() {
    this.speed += 10; 
    console.log(`${this.make} đang đi với tốc độ ${this.speed} km/h`);
};
Car.prototype.brake = function() {
    this.speed -= 5;
    if (this.speed < 0) this.speed = 0;
    console.log(`${this.make} đang đi với tốc độ ${this.speed} km/h`);
};
const car1 = new Car('BMW', 120);
const car2 = new Car('Mercedes', 95);
car1.accelerate(); 
car1.accelerate();
car1.brake(); 
car1.brake(); 
car2.accelerate(); 
