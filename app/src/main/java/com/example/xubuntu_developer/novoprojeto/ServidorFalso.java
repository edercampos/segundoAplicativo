package com.example.xubuntu_developer.novoprojeto;

/**
 * Created by xubuntu-developer on 9/3/15.
 */

public class ServidorFalso {
    public String[][] pegaDados(String tipo) {
        if ("aluno".equals(tipo)) {
            String[][] dados = {
                    {"1442361600", "Situação", "OK"},
                    {"1442361600","Notificação","ok"},
                    {"1442534400","Não se aplica","OK"}
            };

            return dados;
        } else if("professor".equals(tipo)) {
            String[][] dados = {
                    {"1442534400","Lista de Presença","ok"},
                    {"1442534400","Notas","ok"},
                    {"1442534400","Não se Aplica","ok"}
            };
            return dados;
        } else {
            String[][] dados = {
            };
            return dados;
        }
    }
}

