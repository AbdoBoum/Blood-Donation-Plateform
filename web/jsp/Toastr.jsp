<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 25/01/2019
  Time: 01:39
  To change this template use File | Settings | File Templates.
--%>
<script>
    toastr.options = {
        "closeButton": false,
        "debug": false,
        "newestOnTop": false,
        "progressBar": false,
        "positionClass": "toast-bottom-right",
        "preventDuplicates": false,
        "onclick": null,
        "showDuration": "300",
        "hideDuration": "1000",
        "timeOut": "5000",
        "extendedTimeOut": "1000",
        "showEasing": "swing",
        "hideEasing": "linear",
        "showMethod": "fadeIn",
        "hideMethod": "fadeOut"
    };
</script>

<c:if test="${flashMessageFaild ne null}">
    <script>
        toastr.error('${flashMessageFaild}');
    </script>
</c:if>
<c:if test="${flashMessageSuccess ne null}">
    <script>
        toastr.success('${flashMessageSuccess}');
    </script>
</c:if>
