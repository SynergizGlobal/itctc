package com.synergiz.itctc.exception;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.io.IOException;
import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles requests for a "static resource" that doesn't exist -
     * this is exactly what happens when a browser directly visits (or
     * refreshes on) a React Router route like /login or /dashboard,
     * since Spring Boot has no real file with that name.
     *
     * If the missing path is NOT under /api, forward it to index.html
     * so React Router can render the correct page client-side.
     * If it IS under /api, return a proper JSON 404 instead.
     *
     * This must come before the generic Exception.class handler below -
     * Spring Boot automatically prefers the more specific handler, so
     * this one intercepts NoResourceFoundException first.
     */
    @ExceptionHandler(NoResourceFoundException.class)
    public void handleNoResourceFound(
            NoResourceFoundException ex,
            HttpServletRequest request,
            HttpServletResponse response) throws IOException {

        String path = request.getRequestURI();

        if (!path.startsWith("/api")) {
            try {
                request.getRequestDispatcher("/index.html").forward(request, response);
            } catch (Exception forwardEx) {
                response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value());
            }
            return;
        }

        response.setStatus(HttpStatus.NOT_FOUND.value());
        response.setContentType("application/json");
        response.getWriter().write(
                "{\"success\":false,\"status\":404,\"message\":\"Resource not found\",\"path\":\""
                        + path + "\"}"
        );
    }

    /**
     * 400 - Bad Request
     */
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiErrorResponse> handleBadRequest(
            BadRequestException ex,
            HttpServletRequest request) {

        ApiErrorResponse response = new ApiErrorResponse(
                false,
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                request.getRequestURI(),
                LocalDateTime.now()
        );

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    /**
     * 401 - Unauthorized
     */
    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ApiErrorResponse> handleUnauthorized(
            UnauthorizedException ex,
            HttpServletRequest request) {

        ApiErrorResponse response = new ApiErrorResponse(
                false,
                HttpStatus.UNAUTHORIZED.value(),
                ex.getMessage(),
                request.getRequestURI(),
                LocalDateTime.now()
        );

        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }

    /**
     * 404 - Resource Not Found
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleResourceNotFound(
            ResourceNotFoundException ex,
            HttpServletRequest request) {

        ApiErrorResponse response = new ApiErrorResponse(
                false,
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                request.getRequestURI(),
                LocalDateTime.now()
        );

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    /**
     * 409 - Duplicate Resource
     */
    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<ApiErrorResponse> handleDuplicateResource(
            DuplicateResourceException ex,
            HttpServletRequest request) {

        ApiErrorResponse response = new ApiErrorResponse(
                false,
                HttpStatus.CONFLICT.value(),
                ex.getMessage(),
                request.getRequestURI(),
                LocalDateTime.now()
        );

        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    /**
     * 500 - Internal Server Error
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponse> handleException(
            Exception ex,
            HttpServletRequest request) {

        ApiErrorResponse response = new ApiErrorResponse(
                false,
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                ex.getMessage(),
                request.getRequestURI(),
                LocalDateTime.now()
        );

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    /**
     * 400 - Invalid Workflow Status
     */
    @ExceptionHandler(InvalidWorkflowStatusException.class)
    public ResponseEntity<ApiErrorResponse> handleInvalidWorkflowStatus(
            InvalidWorkflowStatusException ex,
            HttpServletRequest request) {

        ApiErrorResponse response = new ApiErrorResponse(
                false,
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                request.getRequestURI(),
                LocalDateTime.now()
        );

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }


}