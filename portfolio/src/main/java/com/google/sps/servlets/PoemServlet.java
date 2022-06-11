package com.google.sps.servlets;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import scorex.util.ArrayList;

/** Handles requests sent to the /poem URL.*/
@WebServlet("/poem")
public class PoemServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    ArrayList<String> poems = new ArrayList<>();
    poems.add("Let life be beautiful like summer flowers and death like autumn leaves.  by Rabindranath Tagore");
    poems.add("Do it or do not do it - you will regret both.  by Soren Kierkegaard");        
    poems.add("Live in the moment, just take it all in. Pay attention to everything,right there and right then.  by Pat A. Fleming");      

    // Convert the server stats to JSON
    Poem poemPiece = new Poem(poems);
    String json = convertToJsonUsingGson(poemPiece);

    // Send the JSON as the response
    response.setContentType("application/json;");
    response.getWriter().println(json);
    }

    private String convertToJsonUsingGson(Poem poemPiece) {
        Gson gson = new Gson();
        String json = gson.toJson(poemPiece);
        return json;
    }
}
