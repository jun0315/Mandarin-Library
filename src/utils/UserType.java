package utils;


//管理员类型相关枚举
public enum UserType {
    Admin,
    Librarian,
    Reader,
    None;

    public static UserType ToUserType(String type) {
        if (type.equals("Admin")) {
            return UserType.Admin;
        } else if (type.equals("Librarian")) {
            return UserType.Librarian;
        } else if (type.equals("Reader")) {
            return UserType.Reader;
        } else {
            return UserType.None;
        }
    }
}