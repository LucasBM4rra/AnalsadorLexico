import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Lexer {
    public TabelaDeSimbolos objTabelaDeSimbolos = new TabelaDeSimbolos();
    public ArrayList<ClassificacaoLexica> ArrayListAnaliseLexica = new ArrayList<>();

    boolean TokenVOID(String Lexema){
        if(Lexema.equals("void"))
            return true;
        else return false;
    }

    boolean TokenMain(String Lexema){
        if(Lexema.equals("main"))
            return true;
        else return false;
    }

    boolean TokenTipoInteiro(String Lexema){
        if(Lexema.equals("int"))
            return true;
        else return false;
    }

    boolean TokenTipoChar(String Lexema){
        if(Lexema.equals("char"))
            return true;
        else return false;
    }

    boolean TokenTipoFloat(String Lexema){
        if(Lexema.equals("float"))
            return true;
        else return false;
    }

    boolean TokenTipoPrintln(String Lexema){
        if(Lexema.equals("println"))
            return true;
        else return false;
    }

    boolean TokenTipoScanf(String Lexema){
        if(Lexema.equals("scanf"))
            return true;
        else return false;
    }

    boolean TokenTipoAtribuicao(String Lexema){
        if(Lexema.equals("="))
            return true;
        else return false;
    }

    boolean TokenPontoVirgula(String Lexema){
        if(Lexema.equals(";"))
            return true;
        else return false;
    }

    boolean TokenAbreChave(String Lexema){
        if(Lexema.equals("{"))
            return true;
        else return false;
    }

    boolean TokenFechaChave(String Lexema){
        if(Lexema.equals("}"))
            return true;
        else return false;
    }

    boolean TokenAbreParentese(String Lexema){
        if(Lexema.equals("("))
            return true;
        else return false;
    }

    boolean TokenFechaParentese(String Lexema){
        if(Lexema.equals(")"))
            return true;
        else return false;
    }

    boolean TokenAdicao(String Lexema){
        if(Lexema.equals("+"))
            return true;
        else return false;
    }

    boolean TokenVirgula(String Lexema){
        if(Lexema.equals(","))
            return true;
        else return false;
    }

    boolean EhDigito(char caracter){
        if (( (caracter == '0') || (caracter == '1') || (caracter == '2') || (caracter == '3') ||
                (caracter =='4') || (caracter == '5') || caracter == ('6') || caracter == ('7') ||
                caracter == ('8') || caracter == ('9')) == false)
            return false;
        else return true;
    }

    boolean EhDigito_(char str){
        if (Character.isDigit(str))
            return true;
        else return false;
    }

    boolean EhLetra(char str){
        if (Character.isLetter(str))
            return true;
        else return false;
    }

    boolean TokenNumeroInteiro(String Lexema){
        int tamanho = Lexema.length();

        for (int i = 0; i < tamanho; i++){
            char pedacoLexema = Lexema.charAt(i);

            if (EhDigito(pedacoLexema) == false)
                return false;
        }
        return true;
    }

    boolean TokenVariavel(String Lexema){
        int tamanho = Lexema.length();

        for (int i = 0; i < tamanho; i++){
            char pedacoLexema = Lexema.charAt(i);

            if (i == 0){
                if (((pedacoLexema == '_') || (EhLetra(pedacoLexema) ) ) == false)
                    return false;
            }
            else if( (EhLetra(pedacoLexema) || EhDigito(pedacoLexema) || (pedacoLexema == '_')) == false)
                return false;

        }
        return true;
    }

    void ClassificaLexema(String Lexema, int linha){
        if(TokenVOID(Lexema)){
            ArrayListAnaliseLexica.add(new ClassificacaoLexica(Lexema,Token.VOID, linha));
            return;
        }

        if(TokenMain(Lexema)){
            ArrayListAnaliseLexica.add(new ClassificacaoLexica(Lexema,Token.MAIN, linha));
            return;
        }

        if(TokenTipoInteiro(Lexema)){
            ArrayListAnaliseLexica.add(new ClassificacaoLexica(Lexema,Token.INT, linha));
            return;
        }

        if(TokenTipoChar(Lexema)){
            ArrayListAnaliseLexica.add(new ClassificacaoLexica(Lexema,Token.CHAR, linha));
            return;
        }

        if(TokenTipoFloat(Lexema)){
            ArrayListAnaliseLexica.add(new ClassificacaoLexica(Lexema,Token.FLOAT, linha));
            return;
        }

        if(TokenTipoPrintln(Lexema)){
            ArrayListAnaliseLexica.add(new ClassificacaoLexica(Lexema,Token.PRINTLN, linha));
            return;
        }

        if(TokenTipoScanf(Lexema)){
            ArrayListAnaliseLexica.add(new ClassificacaoLexica(Lexema,Token.SCANF, linha));
            return;
        }

        if(TokenTipoAtribuicao(Lexema)){
            ArrayListAnaliseLexica.add(new ClassificacaoLexica(Lexema,Token.ATRIUICAO, linha));
            return;
        }

        if(TokenPontoVirgula(Lexema)){
            ArrayListAnaliseLexica.add(new ClassificacaoLexica(Lexema,Token.PONO_VIRGULA, linha));
            return;
        }

        if(TokenAbreChave(Lexema)){
            ArrayListAnaliseLexica.add(new ClassificacaoLexica(Lexema,Token.ABRE_CHAVE, linha));
            return;
        }

        if(TokenFechaChave(Lexema)){
            ArrayListAnaliseLexica.add(new ClassificacaoLexica(Lexema,Token.FECHA_CHAVE, linha));
            return;
        }

        if(TokenAbreParentese(Lexema)){
            ArrayListAnaliseLexica.add(new ClassificacaoLexica(Lexema,Token.ABRE_PARENTESE, linha));
            return;
        }

        if(TokenFechaParentese(Lexema)){
            ArrayListAnaliseLexica.add(new ClassificacaoLexica(Lexema,Token.FECHA_PARENTESE, linha));
            return;
        }

        if(TokenAdicao(Lexema)){
            ArrayListAnaliseLexica.add(new ClassificacaoLexica(Lexema,Token.ADICAO, linha));
            return;
        }

        if(TokenVirgula(Lexema)){
            ArrayListAnaliseLexica.add(new ClassificacaoLexica(Lexema,Token.VIRGULA, linha));
            return;
        }

        if(TokenNumeroInteiro(Lexema)){
            ArrayListAnaliseLexica.add(new ClassificacaoLexica(Lexema,Token.NUMERO_INTEIRO, linha));
            return;
        }

        if(TokenVariavel(Lexema)){
            ArrayListAnaliseLexica.add(new ClassificacaoLexica(Lexema,Token.VARIAVEL, linha));
            return;
        }

        ArrayListAnaliseLexica.add(new ClassificacaoLexica(Lexema, Token.ERRO_DESCONHECIDO, linha));
        return;
    }

    void GerarTabelaDeSimbolos() {
        objTabelaDeSimbolos.adicionarSimbolo(Token.VOID, "COMANDO VOID");
        objTabelaDeSimbolos.adicionarSimbolo(Token.MAIN, "COMANDO MAIN");
        objTabelaDeSimbolos.adicionarSimbolo(Token.INT, "TIPO INT");
        objTabelaDeSimbolos.adicionarSimbolo(Token.FLOAT, "TIPO FLOAT");
        objTabelaDeSimbolos.adicionarSimbolo(Token.PRINTLN, "COMANDO PRINTLN");
        objTabelaDeSimbolos.adicionarSimbolo(Token.SCANF, "COMANDO SCANF");
        objTabelaDeSimbolos.adicionarSimbolo(Token.ATRIUICAO, "ATRIBUICAO");
        objTabelaDeSimbolos.adicionarSimbolo(Token.PONO_VIRGULA, "PONO_VIRGULA");
        objTabelaDeSimbolos.adicionarSimbolo(Token.ABRE_CHAVE, "ABRE_CHAVE");
        objTabelaDeSimbolos.adicionarSimbolo(Token.FECHA_CHAVE, "FECHA_CHAVE");
        objTabelaDeSimbolos.adicionarSimbolo(Token.ABRE_PARENTESE, "ABRE_PARENTESE");
        objTabelaDeSimbolos.adicionarSimbolo(Token.FECHA_PARENTESE, "FECHA_PARENTESE");
        objTabelaDeSimbolos.adicionarSimbolo(Token.PONTOVIRGULA, "PONTOVIRGULA");
        objTabelaDeSimbolos.adicionarSimbolo(Token.ADICAO, "ADICAO");
        objTabelaDeSimbolos.adicionarSimbolo(Token.VIRGULA, "VIRGULA");
        objTabelaDeSimbolos.adicionarSimbolo(Token.NUMERO_INTEIRO, "NUMERO_INTEIRO");
        objTabelaDeSimbolos.adicionarSimbolo(Token.VARIAVEL, "VARIAVEL");
        objTabelaDeSimbolos.adicionarSimbolo(Token.CHAR, "TIPO CHAR");
        objTabelaDeSimbolos.adicionarSimbolo(Token.ERRO_DESCONHECIDO, " *** ERRO DESCONHECIDO *** ");
    }

    void GerarAnaliseLexica() {
        for (ClassificacaoLexica obj : ArrayListAnaliseLexica){

            String Lexema = obj.Lexema;
            int Linha = obj.Linha;
            int CodigoToken = obj.Token;
            String Simbolo = objTabelaDeSimbolos.buscarValor(CodigoToken);

            System.out.println("Linha: " + Linha + " - Lexema: " + Lexema + " Simbolo " +
                    objTabelaDeSimbolos.buscarValor(CodigoToken)   + " Token" + CodigoToken);
        }
    }

    void AnalisadorLexico(File selectedFile) throws FileNotFoundException{

        GerarTabelaDeSimbolos();

        Scanner LeituraArquivo = new Scanner(selectedFile);
        String TextoArquivoAnalisado;

        System.out.println("\n\n ******** ANALISE LEXICA *********\n\n");

        int linha = 1;
        while(LeituraArquivo.hasNextLine()){
            TextoArquivoAnalisado = LeituraArquivo.nextLine();

            String[] ConjuntoLexemas = TextoArquivoAnalisado.split("\\s+");

            for (String lexema :ConjuntoLexemas){
                ClassificaLexema(lexema, linha);
            }
            linha++;
        }

        LeituraArquivo.close();

        GerarAnaliseLexica();
    }
}
