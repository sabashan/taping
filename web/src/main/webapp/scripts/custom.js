
/*Sidebar control*/
        var $win = $(window);

        function checkScroll() {
            if ($win.scrollTop() > 100) {
                $win.off('scroll', checkScroll);
                $('.topbar').fadeIn(2000);
            }
        }

        $win.scroll(checkScroll);

/*Siddbar toggle*/


        $("#menu-toggle").click(function(e) {
            e.preventDefault();
            $(".topbar-controls,#wrapper,#sidebar-wrapper").toggleClass("active");
        });

/*SPanel Collapse*/

        $('.collapse').collapse(); 

/*Datatable */

       /* $(document).ready(function() {
          $('.datatable').dataTable({
            "sPaginationType": "bs_full"
        }); 
          $('.datatable').each(function(){
            var datatable = $(this);
                // SEARCH - Add the placeholder for Search and Turn this into in-line form control
                var search_input = datatable.closest('.dataTables_wrapper').find('div[id$=_filter] input');
                search_input.attr('placeholder', 'Filter and Search');
                search_input.addClass('search-query form-control stylesearch');
                // LENGTH - Inline-Form control
                var length_sel = datatable.closest('.dataTables_wrapper').find('div[id$=_length] select');
                length_sel.addClass('form-control input-sm ');
            });

          $(".process_status").html("<a href='#' class='btn btn-warning btn-embossed'>Add New Syle</a>");

        });*/


function stylefuzzy(table,schbox){
	
     $( '#'+table ).searchable({
            striped: true,
            searchField   : '#'+schbox,
            searchType: 'fuzzy',
            show: function( elem ) {
                elem.slideDown(100);
            },
            hide: function( elem ) {
                elem.slideUp( 100 );
            }
            
        });
     console.log(table+" - "+schbox);
}