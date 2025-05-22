package com.m2i.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.m2i.dto.ClientCreateDTO;
import com.m2i.dto.ClientDTO;
import com.m2i.service.ClientService;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/clients", "/clients/form"})
public class ClientServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @EJB(beanName = "dbclient")
    private ClientService clientService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();

        if ("/clients".equals(path)) {
            List<ClientDTO> clients = clientService.getAllClients();
            req.setAttribute("clients", clients);
            req.getRequestDispatcher("/WEB-INF/views/clientList.jsp").forward(req, resp);
        } else if ("/clients/form".equals(path)) {
            req.getRequestDispatcher("/WEB-INF/views/clientForm.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nom = req.getParameter("nom");
        String prenom = req.getParameter("prenom");
        String email = req.getParameter("email");
        String telephone = req.getParameter("telephone");

        List<String> erreurs = new ArrayList<>();

        if (nom == null || nom.trim().isEmpty()) {
            erreurs.add("Le nom est obligatoire.");
        }
        if (email == null || email.trim().isEmpty()) {
            erreurs.add("L'email est obligatoire.");
        }
        if (telephone == null || telephone.trim().isEmpty()) {
            erreurs.add("Le téléphone est obligatoire.");
        }

        if (!erreurs.isEmpty()) {
            req.setAttribute("erreurs", erreurs);
            req.setAttribute("nom", nom);
            req.setAttribute("prenom", prenom);
            req.setAttribute("email", email);
            req.setAttribute("telephone", telephone);
            req.getRequestDispatcher("/WEB-INF/views/clientForm.jsp").forward(req, resp);
            return;
        }

        ClientCreateDTO dto = new ClientCreateDTO(nom, prenom, email, telephone);
        clientService.createClient(dto);

        resp.sendRedirect("clients");
    }
}
