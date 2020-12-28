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


async function reimbursementSubmit(e){
    e.preventDefault();

    let reimbursementChoice = document.getElementById("reimbursement-type").value
    console.log(reimbursementChoice)
    let amount = document.getElementById("amount-input").value
    console.log(amount)
    //enhanced object literals
    const addReimbursementRequest = {
        reimbursementChoice,
        amount
    }

    try{
        let res = await fetch("http://localhost:8080/ERS/addReimbursement",{
            method:"POST",
            body: JSON.stringify(addReimbursementRequest),
            headers:{
                "Content-Type" : "application/json"
            }
        })
        let reimbursementAmount = await res.json()
        console.log(reimbursementAmount);
        
    } catch(e) {
        console.log(e);
    }
}

document.getElementsByTagName("form")[0].addEventListener('submit', reimbursementSubmit)





});
