      $(document).ready(function () {
        enableOrDisableDeleteAll();
        autoCheckBoxChild();
        autoCheckBoxParent();
      });	

      function enableOrDisableDeleteAll() {
        $('input[type=checkbox]').click(function (e) { 
          if($('input[type=checkbox]:checked').length > 0){
            $('#btnDelete').prop('disabled',false);
          }else{
            $('#btnDelete').prop('disabled',true);
          }
        });
      }
      
      function autoCheckBoxChild() {
        $('#checkAll').change(function (e) { 
          if(this.checked){
            $(this).closest('table').find('tbody input[type=checkbox]').prop('checked',true);
          }else {
            $(this).closest('table').find('tbody input[type=checkbox]').prop('checked',false);
            $('#btnDelete').prop('disabled',true);
          }
        });
      }
      
      function autoCheckBoxParent(params) {
        var soLuongCheckBoxCon = $('#checkAll').closest('table')
                                      .find('tbody input[type=checkbox]').length;
        $('#checkAll').closest('table').find('tbody input[type=checkbox]').change(function (e) { 
          var soLuongCheckBoxConCheck = $('#checkAll').closest('table')
                    .find('tbody input[type=checkbox]:checked').length;
          if(soLuongCheckBoxConCheck == soLuongCheckBoxCon){
            $('#checkAll').prop('checked',true);
          }
          else{
            $('#checkAll').prop('checked',false);
          }
        });
      }