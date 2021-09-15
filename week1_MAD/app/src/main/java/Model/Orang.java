package Model;


import android.os.Parcel;
import android.os.Parcelable;

public class Orang implements Parcelable {
    private String nama, umur, alamat, image;

    public Orang(String nama, String umur, String alamat, String image) {
        this.nama = nama;
        this.umur = umur;
        this.alamat = alamat;
        this.image = image;
    }

    public Orang(String nama, String umur, String alamat) {
        this.nama = nama;
        this.umur = umur;
        this.alamat = alamat;
        this.image ="";
    }

    public Orang() {
        this.nama = "";
        this.umur = "";
        this.alamat = "";
        this.image = "";
    }


    protected Orang(Parcel in) {
        nama = in.readString();
        umur = in.readString();
        alamat = in.readString();
        image = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nama);
        dest.writeString(umur);
        dest.writeString(alamat);
        dest.writeString(image);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Orang> CREATOR = new Creator<Orang>() {
        @Override
        public Orang createFromParcel(Parcel in) {
            return new Orang(in);
        }

        @Override
        public Orang[] newArray(int size) {
            return new Orang[size];
        }
    };

    //getter

    public String getNama() {
        return nama;
    }

    public String getUmur() {
        return umur;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getImage() {
        return image;
    }

    public static Creator<Orang> getCREATOR() {
        return CREATOR;
    }

    //SETTER
    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setUmur(String umur) {
        this.umur = umur;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setImage(String image) {
        this.image = image;
    }
}