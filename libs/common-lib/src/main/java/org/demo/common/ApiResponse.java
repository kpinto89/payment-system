package org.demo.common;

public record ApiResponse<T>(String status, T data) {}