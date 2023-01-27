package org.iliaglaz.jdbcsimple.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Data;
import org.iliaglaz.jdbcsimple.dto.UserCreateDto;
import org.iliaglaz.jdbcsimple.service.UserService;

import java.io.IOException;

@Data
@WebServlet("/addUser")
public class UserServlet extends HttpServlet {

    private final UserService userService = UserService.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserCreateDto userDto = new UserCreateDto(req.getParameter("name"),
                req.getParameter("country"));

        userService.create(userDto);
    }
}
