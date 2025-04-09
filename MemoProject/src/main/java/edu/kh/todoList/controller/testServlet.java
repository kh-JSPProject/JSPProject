package edu.kh.todoList.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.*;

import java.io.IOException;

/**
 * Servlet implementation class testServlet
 */
@WebServlet("/testServlet")
@ToString
@Getter
@Setter
public class testServlet extends HttpServlet {

}
