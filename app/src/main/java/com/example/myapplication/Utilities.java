package com.example.myapplication;



import androidx.appcompat.app.AppCompatActivity;

enum ErrorCodes
{
    IncorrectAuth, FieldsEmpty, True, False
}

enum AccessoriesCat
{
    scarf,ring,earrings,bracelet,necklace
}

enum ShoesCat
{
    Sandals , flipflop, sneakers
}
enum BagsCat
{
    backpack, laptopbag, wallet
}

enum ClothesCat
{
    dress, tshirt, pants, socks
}

enum DecorCat
{
    decoration, blankets, tables, mirror
}

public class Utilities
{
    private static Utilities instance;

       public Utilities()
       {


       }

    public static Utilities getInstance ()
    {
        if (instance == null)
        {
            instance = new Utilities();
        }

        return instance;
    }

    //email(username and domain)

    public boolean validateEmail(AppCompatActivity activity ,String email)
    {
        return true;
        /*
        String[] splitString = email.split("@");

        if (splitString.length != 2) {
            Toast.makeText(activity, "Username or password are incorrect!", Toast.LENGTH_SHORT).show();
            return false;
        }

        String username = splitString[0];
        String domain = splitString[1];
        String[]splitusername=username.split("");
        if (splitusername.length!=1){
            Toast.makeText(activity, "username or password are incorrect", Toast.LENGTH_SHORT).show();
            return false;
        }
        char first=username.charAt(0);
        if (!(first>='a' & first<='z'|| first == '_')) {
            Toast.makeText(activity, "username or password are incorrect", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (username.length()>70){
            Toast.makeText(activity, "username or password are incorrect ", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (username.length()<3){
            Toast.makeText(activity, "username or password are incorrect ", Toast.LENGTH_SHORT).show();
            return false;
        }
        for (int i=0;i<username.length();i++){
            char p=username.charAt(i);
            if (!(p>='a' & p<='z' || p<='A' & p<='Z' || p=='_' || p>='0' & p<='9')){
                Toast.makeText(activity, "username or password are in correct ", Toast.LENGTH_SHORT).show();
                return false;
            }
        }

        if (!(domain.split(".").length>=2 && domain.split(".").length<=5)) return false;
        char firstd = domain.charAt(0);
        if (!(firstd>='a'&& firstd<='z' || firstd=='_'|| firstd>='A'&& firstd<='Z')){
            Toast.makeText(activity, "username or password are incorrect", Toast.LENGTH_SHORT).show();
            return false;

        }

        for (int i=0;i<domain.length();i++){
            char p = domain.charAt(i);
            if (!(p>='a'&& p<='z'||p>='A'&& p<='Z'|| p=='_' ||p>='0'||p<='9' )){
                Toast.makeText(activity, "username or password are incorrect", Toast.LENGTH_SHORT).show();
                return false;
            }
        }
        String[]dot= domain.split(".");
        String laststring = dot[dot.length-1];
        for (int i=0;i<laststring.length();i++){
            char p = laststring.charAt(i);
            if (!(p>='a'&& p<='z'||p>='A'&& p<='Z')){
                Toast.makeText(activity, "username or password are incorrect", Toast.LENGTH_SHORT).show();
                return false;
            }
        }
        return  true;*/

    }


    //password

    public boolean validatepassword(AppCompatActivity activity ,String password)
    {
        return true;
        /*
        int countsmall = 0, countcapital = 0, countwildcard = 0, countnumber = 0;
        if (password.length() > 30) {
            Toast.makeText(activity, "username or password are incorrect", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (password.length() < 8) {
            Toast.makeText(activity, "username or password are incorrect ", Toast.LENGTH_SHORT).show();
            return false;
        }
        for (int i = 0; i < password.length(); i++) {

            char p = password.charAt(i);
            if (p >= 'a' & p <= 'z') countsmall++;
            if (p <= 'A' & p <= 'Z') countcapital++;
            if (!(p >= 'a' & p <= 'z' || p <= 'A' & p <= 'Z' || p >= '0' & p <= '9'))
                countwildcard++;
            if (p >= '0' & p <= '9') countnumber++;

        }
        if (countsmall == 0 || countcapital == 0 || countwildcard == 0 || countnumber == 0) {
            Toast.makeText(activity, "username or password are incorrect", Toast.LENGTH_SHORT).show();

            return false;

        }

        return true;*/
    }
    public boolean checkTrimEmpty(String text)
    {
        return text.trim().isEmpty();
    }

}
