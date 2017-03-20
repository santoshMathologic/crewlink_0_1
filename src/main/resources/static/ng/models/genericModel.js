/**
 * 
 */

function Person() {
   this.name = "Call from Generic Model";
   return this;
}

var person = new Person();


console.log(""+person.name);


function getMontlhlyFee(fee){
	  var remaining = this.total - fee;
	  this.total = remaining;
	  return this.name +' remaining balance:'+remaining;
	  
	}
	var rachel = {name:'Rachel Green', total:500};

	var getRachelFee =getMontlhlyFee.bind(rachel, 90);
	//deduct

	console.log(getRachelFee());//Rachel Green remaining balance:410
	getRachelFee();



	var person = {  
	  name: "James Smith",
	  hello: function(thing) {
	    console.log(this.name + " says hello " + thing);
	  }
	}

	var helloFunc = person.hello.bind(person);
	helloFunc("world"); 

	function multiplication(a,b){
	   return a*b;
	}

	var multiby2 = multiplication.bind(this,2);

	multiby2(3); //6
	multiby2(4); //8