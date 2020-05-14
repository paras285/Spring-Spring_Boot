#Spring Boot Rest Exception Handling#

This contains various ways of Exception Handling in Spring Boot

##Controllers name are just to indicate the different way of handling Exception##

###ExceptionHandlerEmployeeController --> This Controller is handling the exception at Controller Level###
###ControllerAdviceEmployeeController --> This Controller is throwing custom exception from Controller and that custom exceptions are handled by **ExceptionHandlerAdvice**
###ResponseStatusEmployeeController --> We can directly create instance of ResponseStatusException and have the required HttpStatus along with reason and cause of that exception

Further, we can create custom error response, by creating a class and creating an instance of it whenever we throw any exception

@ExceptionHandler --> This is used to handle exceptions at **Controller-level**
@ControllerAdvice --> This is used to handle exceptions at **Global-level**
ResponseStatusException --> Introduced in Spring 5.x+ , maps the customs status along with reason and cause while throwing the exception

@ResponseStatus --> By Default, if any exception is thrown, Default Http Status is 500 i.e InternalServerError
We can customize it using @ResponseStatus.

If we want to send custom status instead of default-ones we can use @ResponseStatus
**For Example**:
If the request is successful, we can send Http Status 201 instead of default 200 by adding an annotation on top of method