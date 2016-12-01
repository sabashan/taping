 var productOrder =new Array();
$(document).ready(function() {

    // adding the Accordion Function to work properly start.

    var active = true;

    $('#accordion2 .panel-collapse').collapse('hide');
    $('#accordion2 .panel-title').attr('data-toggle', 'collapse');

    $('#accordion2').on('show.bs.collapse', function () {
        if (active) $('#accordion2 .in').collapse('hide');     
    });
    // adding the Accordion Function working ends.
 
    $('.table-hover>tbody>tr').click(function(event) {
        $('.table-hover>tbody>tr').not(this).removeClass('clicked');
        $(this).toggleClass('clicked'); 
    });
    
    $('#mststyleoperationLists>tbody>tr').click(function(event) {
        $('.table-hover>tbody>tr').not(this).removeClass('clicked');
        $(this).toggleClass('clicked mywebstyleoperation'); 
        var id=  $(".mywebstyleoperation td").first().html();
        var option= "";
        console.info( id ); 
        
        locationCode = document.getElementById("rop_id_locationCode").value;
		compCode = document.getElementById("rop_id_compCode").value;
		custCode = document.getElementById("rop_id_custCode").value;
		styleId = document.getElementById("rop_id_styleId").value;
		depCode = document.getElementById("rop_id_depCode").value;
		componentId = document.getElementById("rop_id_componentId").value;
		mainColor = document.getElementById("rop_id_mainColor").value;
		styleDescription = document.getElementById("rop_styleDescription").value;
		styleRouteId = document.getElementById("rop_id_styleRouteId").value;
		
		option="$('#routoperationreset').trigger('click');"
    	option=option+"getstyleroutoperation('"+id+"', '"+componentId+"', '"+mainColor+"', '"+styleRouteId+"', '"+styleId+"', '"+locationCode+"', '"+custCode+"', '"+compCode+"', '"+depCode+"','update');"
    	option=option+"document.getElementById('id_opeartionNo').value=''";
        $('#duplicate-opat-btn').unbind('click');
        $('#duplicate-opat-btn').attr('onclick', ''+option+'');
       
        
    });

   $('#duplicate-opat-btn').click(function(){

         var $aSelected = $('#oparations-grid tbody tr').find( ".selected" );

         if ($aSelected.hasClass('selected')){

            alert('row selected');

         }else{
            alert('nothing selected');
         }     
   });

   $( ".view-style-operations-jq" ).click(function() {

     $( ".table-toggle-jquery" ).toggle('slow');

     $('.view-style-operations-jq .glyphicon').removeClass('glyphicon-chevron-right').addClass('glyphicon-chevron-down');

   });

   
   $('.slideupdowntoggle.glyphicon').click(function () {
        var el = $(this).parents(".panel-title").children(".glyphicon");
        if ($(this).hasClass("glyphicon-chevron-up")) {
            $(this).removeClass("glyphicon-chevron-up").addClass("glyphicon-chevron-down");
            el.slideUp(200);
        } else {
            $(this).removeClass("glyphicon-chevron-down").addClass("glyphicon-chevron-up");
            el.slideDown(200); }
    });

/*drop down toggle class added - muditha edited*/
    $('.slideupdowntogglered.glyphicon').click(function () {
        var el = $(this).parents(".panel-title").children(".glyphicon");
        if ($(this).hasClass("glyphicon-chevron-up")) {
            $(this).removeClass("glyphicon-chevron-up").addClass("glyphicon-chevron-down");
            el.slideUp(200);
        } else {
            $(this).removeClass("glyphicon-chevron-down").addClass("glyphicon-chevron-up");
            el.slideDown(200); }
    });
  
   // WIP-points.html table + button functionality start

   showHideTr();

   

  
   // WIP-points.html table + button functionality Ends

   // search dropdown propagation start

   $( ".form-control-custom-top" ).click(function(e) {
        e.stopPropagation();  // this is used to keep the top nav search dropdown clickable
    });

   // search dropdown propagation ends


   $( ".delete-model-close-x-btn" ).click(function() {

        $('.delete-confirmation').modal('hide');
    });


   //$('.targetDate').datepicker()
   var targetDate =  $('.targetDate');

   if(targetDate){

     $('.targetDate').datepicker({
          autoclose: true,
  		format: 'mm/dd/yyyy'
      });

   }
   
  //adding yes no chekbox start

  var yesNoCheckBox = $('#compWiseCost'); // checking yesNoCheckBox is inside the body

   if(yesNoCheckBox.hasClass("yesNocheckBox") ){

     $.fn.bootstrapSwitch.defaults.onText = 'Yes';
     $.fn.bootstrapSwitch.defaults.offText = 'No';

     $("[name='compWiseCost']").bootstrapSwitch();

   }
   //adding yes no chekbox end

   //adding bootstrap tooltip start
   
   $('#buttonwithEye, #buttonwithEye2, #buttonwithEye3').tooltip();
   //adding bootstrap tooltip end

   // checking popover content exists or not
   /*if($('div').hasClass("popover-content") ){
  
      //adding bootstrap popover start
     $('.danger').popover({ 
        html : true,
        placement : 'top',
        //trigger: 'focus',
        content: function() {
          return $('#popover_content_wrapper').html();
        }
      });
     //adding bootstrap popover ends
   }
    */
   
   if($('button').hasClass("danger") ){
	   
	      //adding bootstrap popover start
	     $('.danger').popover({ 
	        html : true,
	        placement : 'top',
	        //trigger: 'focus',
	        content: function() {
	          return $('#popover_content_wrapper').html();
	        }
	      });
	     //adding bootstrap popover ends
	   }
  // nav tab-pill adding active class on click start
   $('.nav-pills-jq li').click(function(){

      $('.nav-pills-jq li a').removeAttr('href');
      $('.nav-pills-jq li').removeClass('active');
      $(this).addClass('active');

   });
   
   // nav tab-pill adding active class on click Ends

// appending exportlinks to the panel body start
   $("#styleBrowserBody2 .expolinks").appendTo("#styleBrowserBody2 .panel-body");
   $("#styleBrowserBody .expolinks").appendTo("#styleBrowserBody .panel-body");
   // appending exportlinks to the panel body ends

  /* var tabindex = 1;
    $('input,select').each(function() {
        if (this.type != "hidden" || this.type != "readonly") {
            var $input = $(this);
            $input.attr("tabindex", tabindex);
            tabindex++;
        }
    });;*/
  
   $('.sortable').sortable({
       update: function(event, ui) {
			productOrder = $(this).sortable('toArray');
			productOrder=cleanArray(productOrder);
         // $("#sortable-text").text (productOrder);
       }
    });
   /*example of panel show hide ends*/
   if($('select').hasClass("chosen-select") ){
     $(".chosen-select").chosen();
   }
   /*
   $(".showHideTable").hide();
   $('.table_show_hide').click(function(){
     $(".showHideTable").toggle(350);
      generateMatrix('grid');
   });*/
}); // End of the Document Ready Function


function showHideTr(){

  $('.addit-btn').click(function(){

       var plusIcon = $(this).children("span").hasClass('glyphicon-plus');

       if(plusIcon){
          $(this).children("span").removeClass('glyphicon-plus').addClass('glyphicon-minus');
          $(this).parent().parent().next().toggle();
       }else{
          $(this).children("span").removeClass('glyphicon-minus').addClass('glyphicon-plus');
          $(this).parent().parent().next().toggle();
       }

   });
}


//alert('sdfasdf');

