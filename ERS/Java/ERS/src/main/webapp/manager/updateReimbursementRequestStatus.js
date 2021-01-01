async function approveReimbursementStatus(e){

    let id = document.getElementById("reimbId-input").value
    console.log(id)

    //enhanced object literals
    const updateReimbStatus = {
        id        
    }

    try{
        let res = await fetch("http://localhost:8080/ERS/manager/updateReimbursementRequestStatus/approve",{
            method:"POST",
            body: JSON.stringify(updateReimbStatus),
            headers:{
                "Content-Type" : "application/json"
            }
        })
       
        let updateReimbursement = await res.json()
        console.log(updateReimbursement);
               
    } catch(error) {
        console.log('Error',error);
    }
}


async function denyReimbursementStatus(e){

    let id = document.getElementById("reimbId-input").value
    console.log(id)

    //enhanced object literals
    const updateReimbStatus = {
        id        
    }

    try{
        let res = await fetch("http://localhost:8080/ERS/manager/updateReimbursementRequestStatus/deny",{
            method:"POST",
            body: JSON.stringify(updateReimbStatus),
            headers:{
                "Content-Type" : "application/json"
            }
        })
       
        let updateReimbursement = await res.json()
        console.log(updateReimbursement);
               
    } catch(error) {
        console.log('Error',error);
    }
}
if(document.getElementById('approve-button').onclick === true){
    document.getElementById("update-reimbursement-status").addEventListener('submit', approveReimbursementStatus)
} else if(document.getElementById('deny-button').onclick === true){
    document.getElementById("update-reimbursement-status").addEventListener('submit', denyReimbursementStatus)
} else{
    console.log("invalid choice")
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
