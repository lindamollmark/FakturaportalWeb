package se.fakturaportal.utilityClasses;

/**
 * Created by Linda on 2016-05-15.
 */

    import com.google.common.base.Charsets;
    import com.google.common.hash.Hashing;

    public class SHA256 {

        String hashValue;

        public SHA256(String plain) {
            hashValue = Hashing.sha256().hashString(plain, Charsets.UTF_8).toString();
        }

        public String getHashValue() {
            return hashValue;
        }


}
