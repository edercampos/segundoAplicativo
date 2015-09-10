package com.example.xubuntu_developer.novoprojeto;

import android.provider.BaseColumns;

/**
 * Created by xubuntu-developer on 9/10/15.
 */
public class contratoDB {

    public static final class Aluno implements BaseColumns {

        public static final String NOME_TABELA = "aluno";

                public static final String COLUNA_DATA = "data";
                public static final String COLUNA_TIPO = "tipo";
                public static final String COLUNA_MENSAGEM = "mensagem";

    }
}
