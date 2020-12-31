async function travelReimbursementStatus(e){

    let amount = document.getElementById("amount-input").value
    console.log(amount)

    //enhanced object literals
    const updateAmount = {
        amount        
    }

    try{
        let res = await fetch("http://localhost:8080/ERS/employee/reimbursementRequest/travel",{
            method:"POST",
            body: JSON.stringify(updateAmount),
            headers:{
                "Content-Type" : "application/json"
            }
        })
       
        let updateAmountStatus = await res.json()
        console.log(updateAmountStatus);
               
    } catch(error) {
        console.log('Error',error);
    }
}


async function lodgingReimbursementStatus(e){

    let amount = document.getElementById("amount-input").value
    console.log(amount)

    //enhanced object literals
    const updateAmount = {
        amount        
    }

    try{
        let res = await fetch("http://localhost:8080/ERS/employee/reimbursementRequest/lodging",{
            method:"POST",
            body: JSON.stringify(updateAmount),
            headers:{
                "Content-Type" : "application/json"
            }
        })
       
        let updateAmountStatus = await res.json()
        console.log(updateAmountStatus);
               
    } catch(error) {
        console.log('Error',error);
    }
}
async function foodReimbursementStatus(e){

    let amount = document.getElementById("amount-input").value
    console.log(amount)

    //enhanced object literals
    const updateAmount = {
        amount        
    }

    try{
        let res = await fetch("http://localhost:8080/ERS/employee/reimbursementRequest/food",{
            method:"POST",
            body: JSON.stringify(updateAmount),
            headers:{
                "Content-Type" : "application/json"
            }
        })
       
        let updateAmountStatus = await res.json()
        console.log(updateAmountStatus);
               
    } catch(error) {
        console.log('Error',error);
    }
}
async function otherReimbursementStatus(e){

    let amount = document.getElementById("amount-input").value
    console.log(amount)

    //enhanced object literals
    const updateAmount = {
        amount        
    }

    try{
        let res = await fetch("http://localhost:8080/ERS/employee/reimbursementRequest/other",{
            method:"POST",
            body: JSON.stringify(updateAmount),
            headers:{
                "Content-Type" : "application/json"
            }
        })
       
        let updateAmountStatus = await res.json()
        console.log(updateAmountStatus);
               
    } catch(error) {
        console.log('Error',error);
    }
}
if(document.getElementById('travel-button').onclick === true){
    document.getElementById("update-reimbursement-status").addEventListener('submit', travelReimbursement)
} else if(document.getElementById('lodging-button').onclick === true){
    document.getElementById("update-reimbursement-status").addEventListener('submit', lodgingReimbursement)
} else if(document.getElementById('food-button').onclick === true){
    document.getElementById("update-reimbursement-status").addEventListener('submit', foodReimbursement)
} else if(document.getElementById('other-button').onclick === true){
    document.getElementById("update-reimbursement-status").addEventListener('submit', otherReimbursement)
}



$(document).ready(function(){
    // Requires jQuery

$(document).on('click','.js-menu_toggle.closed',function(e){
	e.preventDefault(); $('.list_load, .list_item').stop();
	$(this).removeClass('closed').addClass('opened');

	$('.side_menu').css({ 'left':'0px' });

	var count = $('.list_item').length;
	$('.list_load').slideDown( (count*.6)*100 );
	$('.list_item').each(function(i){
		var thisLI = $(this);
		timeOut = 100*i;
		setTimeout(function(){
			thisLI.css({
				'opacity':'1',
				'margin-left':'0'
			});
		},100*i);
	});
});

$(document).on('click','.js-menu_toggle.opened',function(e){
	e.preventDefault(); $('.list_load, .list_item').stop();
	$(this).removeClass('opened').addClass('closed');

	$('.side_menu').css({ 'left':'-250px' });

	var count = $('.list_item').length;
	$('.list_item').css({
		'opacity':'0',
		'margin-left':'-20px'
	});
	$('.list_load').slideUp(300);
});    
});








