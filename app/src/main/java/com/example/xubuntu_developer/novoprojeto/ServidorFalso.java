package com.example.xubuntu_developer.novoprojeto;

/**
 * Created by xubuntu-developer on 9/3/15.
 */

public class ServidorFalso {
    public String[] pegaDados(String tipo) {
        if ("aluno".equals(tipo)) {
            String[] dados = {
                    "Situação",
                    "Notificação"
            };

            return dados;
        } else if("professor".equals(tipo)) {
            String[] dados = {
                    "Lista de Presença",
                    "Notas"
            };
            return dados;
        } else {
            String[] dados = {
            };
            return dados;
        }
    }
}

