package JavaFX_project.Database;

public class TableCodecs {

    private int codec_id;               // id_kodeka
    private String codec_name;          // nazwa_kodeka
    private String frequency_range;     // zakres_czestotliwosci
    private float max_kbps_bitrate;     // maks_przeplywnosc_kbps
    private float frame_ms;             // ramka_ms
    private int max_bits_per_frame;     // maks_ilosc_bitow_na_ramke
    private float algorithmic_delay_ms; // opoznienie_algorytmiczne_ms
    private String codec_category;      // kategoria
    private String compression_family;  // rodzina_kompresji
    private String compression_variant; // wariant_kompresji
    private float mips;                 // maks_mips
    private String mos;                 // mos
    //private float mos;                  // mos

    public TableCodecs() {
    }

    public TableCodecs(int codec_id, String codec_name, String frequency_range, float max_kbps_bitrate,
                       float frame_ms, int max_bits_per_frame, float algorithmic_delay_ms, String codec_category,
                       String compression_family, String compression_variant, float mips, String mos) {
        this.codec_id = codec_id;
        this.codec_name = codec_name;
        this.frequency_range = frequency_range;
        this.max_kbps_bitrate = max_kbps_bitrate;
        this.frame_ms = frame_ms;
        this.max_bits_per_frame = max_bits_per_frame;
        this.algorithmic_delay_ms = algorithmic_delay_ms;
        this.codec_category = codec_category;
        this.compression_family = compression_family;
        this.compression_variant = compression_variant;
        this.mips = mips;
        this.mos = mos;
    }

    public int getCodec_id() {
        return codec_id;
    }

    public void setCodec_id(int codec_id) {
        this.codec_id = codec_id;
    }

    public String getCodec_name() {
        return codec_name;
    }

    public void setCodec_name(String codec_name) {
        this.codec_name = codec_name;
    }

    public String getFrequency_range() {
        return frequency_range;
    }

    public void setFrequency_range(String frequency_range) {
        this.frequency_range = frequency_range;
    }

    public float getMax_kbps_bitrate() {
        return max_kbps_bitrate;
    }

    public void setMax_kbps_bitrate(float max_kbps_bitrate) {
        this.max_kbps_bitrate = max_kbps_bitrate;
    }

    public float getFrame_ms() {
        return frame_ms;
    }

    public void setFrame_ms(float frame_ms) {
        this.frame_ms = frame_ms;
    }

    public int getMax_bits_per_frame() {
        return max_bits_per_frame;
    }

    public void setMax_bits_per_frame(int max_bits_per_frame) {
        this.max_bits_per_frame = max_bits_per_frame;
    }

    public float getAlgorithmic_delay_ms() {
        return algorithmic_delay_ms;
    }

    public void setAlgorithmic_delay_ms(float algorithmic_delay_ms) {
        this.algorithmic_delay_ms = algorithmic_delay_ms;
    }

    public String getCodec_category() {
        return codec_category;
    }

    public void setCodec_category(String codec_category) {
        this.codec_category = codec_category;
    }

    public String getCompression_family() {
        return compression_family;
    }

    public void setCompression_family(String compression_family) {
        this.compression_family = compression_family;
    }

    public String getCompression_variant() {
        return compression_variant;
    }

    public void setCompression_variant(String compression_variant) {
        this.compression_variant = compression_variant;
    }

    public float getMips() {
        return mips;
    }

    public void setMips(float mips) {
        this.mips = mips;
    }

    public String getMos() {
        return mos;
    }

    public void setMos(String mos) {
        this.mos = mos;
    }

    /*@Override
    public String toString() {
        return "{" + "id_kodeka=" + codec_id + ", nazwa_kodeka=" + codec_name + ", zakres_czestotliwosci=" +
        frequency_range
                + ", maks_przeplywnosc_kbps=" + max_kbps_bitrate + ", ramka_ms=" + frame_ms
                + ", maks_ilosc_bitow_na_ramke=" + max_bits_per_frame + ", opoznienie_algorytmiczne_ms=" +
                algorithmic_delay_ms
                + ", typ_kompresji=" + compression_type + ", maks_mips=" + mips + ", mos=" + mos + '}';
    }*/

    /*@Override
    public String toString() {
        return "{\n " + '"' + "id_kodeka" + '"' + ':' + '"' + codec_id + '"' +
                ",\n    " + '"' + "nazwa_kodeka" + '"' + ':' + '"' + codec_name + '"' +
                ",\n    " + '"' + "zakres_czestotliwosci" + '"' + ':' + '"' + frequency_range + '"' +
                ",\n    " + '"' + "maks_przeplywnosc_kbps" + '"' + ':' + '"' + max_kbps_bitrate + '"' +
                ",\n    " + '"' + "ramka_ms" + '"' + ':' + '"' + frame_ms + '"' +
                ",\n    " + '"' + "maks_ilosc_bitow_na_ramke" + '"' + ':' + '"' + max_bits_per_frame + '"' +
                ",\n    " + '"' + "opoznienie_algorytmiczne_ms" + '"' + ':' + '"' + algorithmic_delay_ms + '"' +
                ",\n    " + '"' + "typ_kompresji" + '"' + ':' + '"' + compression_type + '"' +
                ",\n    " + '"' + "maks_mips" + '"' + ':' + '"' + mips + '"' +
                ",\n    " + '"' + "mos" + '"' + ':' + '"' + mos + '"' + "\n}";
    }*/

    @Override
    public String toString() {
        return "\n    " + "id_kodeka: " + codec_id +
                ",\n    " + "Nazwa kodeka: " + codec_name +
                ",\n    " + "Zakres częstotliwości: " + frequency_range +
                ",\n    " + "Maksymalna przepływność (kb/s): " + max_kbps_bitrate +
                ",\n    " + "Ramka (ms): " + frame_ms +
                ",\n    " + "Maksymalna ilość bitów na ramkę: " + max_bits_per_frame +
                ",\n    " + "Opóźnienie algorytmiczne (ms): " + algorithmic_delay_ms +
                ",\n    " + "Kategoria kodeka: " + codec_category +
                ",\n    " + "Rodzina kompresji: " + compression_family +
                ",\n    " + "Wariant kompresji: " + compression_variant +
                ",\n    " + "Maksymalna wartość MIPS: " + mips +
                ",\n    " + "MOS: " + mos;
    }
}
