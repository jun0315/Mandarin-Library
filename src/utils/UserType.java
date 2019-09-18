package utils;


//管理员类型相关枚举
public enum UserType {
    Admin,
    Librarian,
    Reader,
    None;

    public static UserType ToUserType(String type) {
        if (type.equals("admin")) {
            return UserType.Admin;
        } else if (type.equals("librarian")) {
            return UserType.Librarian;
        } else if (type.equals("reader")) {
            return UserType.Reader;
        } else {
            return UserType.None;
        }
    }
}