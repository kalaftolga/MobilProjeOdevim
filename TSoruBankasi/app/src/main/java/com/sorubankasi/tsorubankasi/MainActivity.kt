package com.sorubankasi.tsorubankasi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import com.sorubankasi.tsorubankasi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var dogrucevap: String? = null
    private var dogrucevapsayim = 0
    private var sorusayi = 1
    private var SORU_SAYI = 5

    private val soruveri = mutableListOf(
        mutableListOf("Aşağıdaki cümlelerin hangisinde ünsüz yumuşaması vardır?" , "Yapılan yöresel yemeklerin tadı çok güzelmiş." , "Sokaktaki kedi miyavlayarak uzaklaştı." , "Gelecek güzel günler için çalışmalıyız." , "Su, bu topraklar üzerinden akıyor."),
        mutableListOf("Aşağıdaki cümlelerin hangisinde ünsüz yumuşamasına uğramış bir kelime yoktur?" , "Kardeşim merdivenlerden çıktı." , "Bu soğuğa dikkat edelim." , "Anahtarı bulamayınca kilidi kırdılar." , "Böceği sen gördün mü?"),
        mutableListOf("Aşağıdaki cümlelerin hangisinde ünsüz benzeşmesi olmamıştır?" , "İnsanca yaşamalıyız." , "Onu sokakta gördüm." , "Türkçe dersini çok seviyorum." , "Şu kebapçı   yeni açılmış."),
        mutableListOf("Aşağıdaki cümlelerin hangisinde sert ünsüz benzeşmesi kuralına ait bir kelime yoktur?" , "Ülkemizi biz kurduk yaşatacak olan da yine bizleriz." , "Akşamleyin sokakta birçok kişi kavga etti." , "Rusça bazı kişilere göre öğrenilmesi zor bir dildir." , "Ali bu konuda yine baskın çıktı."),
        mutableListOf("Aşağıdaki cümlelerin hangisinde ünsüz yumuşaması vardır?" , "Yurdumu çok seviyorum." , "Çocuklar küçük yaşlarda eğitilir." , "Akşam olunca kocası işten gelir." , "Burası doğal güzellikleriyle tanınır."),
        mutableListOf("Aşağıdaki sözcüklerden hangisinin sonuna bir ünlü getirildiğinde ses değişimi olmaz?" , "Sırt" , "Kabak" , "Yurt" , "Ekmek"),
        mutableListOf("Aşağıdaki cümlelerden hangisinde ünsüz benzeşmesine bir örnek vardır?" , "Hiç parası kalmamıştı." , "Bu mahallede fakir insanlar yaşıyor." , "Yarın tatilden dönecek." , "Bir bardak su verir misin?"),
        mutableListOf("Ondan bir şey istemek ağrıma gitti.” cümlesinde görülen ses olayları hangi seçenekte sırasıyla verilmiştir?" , "Kaynaşma- ulama- ulama-ünlü düşmesi- benzeşme" , "Kaynaşma- ulama- ünlü düşmesi- kaynaşma- benzeşme" , "Ulama- ulama- ünlü düşmesi- yumuşama-benzeşme" , "Kaynaşma –benzeşme- benzeşme-ünlü düşmesi -benzeşme"),
        mutableListOf("Aşağıdaki cümlelerin hangisinde hem ünsüz benzeşmesi hem de ünsüz yumuşaması meydana gelmiştir?" , "Karşısında onu görünce renkten renge girdi." , "Yüreğindeki korku bir türlü geçmek bilmiyordu." , "Taştan yapılmış duvar, yıllara meydan okuyordu." , "Kafasına koyduğu her işi bitirirdi."),
        mutableListOf("Aşağıdakilerden hangisinde hiçbir ses olayı yoktur?" , "Onu burada görmedim." , "Ateşini alnından ölçtük." , "Kitabın sayfaları birbirine karışmıştı." , "Ondan sonra bunu affetmem."),
        mutableListOf("Aşağıdaki cümlelerin hangisinde kaynaştırma ünsüzü kullanılmamıştır?" , "Tenleri kısa sürede esmerleşti." , "Çocuklar okul bahçesine doluştular." , "Hafta sonu geziye çıkacağız." , "Her sınıftan ikişer öğrenci"),
        mutableListOf("Aşağıdaki birleşik isimlerden hangisi ses aşınması yoluyla olmuştur?" , "Kahvaltı" , "Uyurgezer" , "Kızılay" , "Ateşkes"),
        mutableListOf("Aşağıdaki sözcüklerin hangisinde farklı bir ses olayı vardır?" , "Zambağın" , "Yürekte" , "Alıştım" , "Parkta"),
        mutableListOf("Aşağıdaki cümlelerin hangisinde ünsüz benzeşmesine örnek yoktur?" , "Ağacın yapraklarına daldı." , "Ceketteki lekeyi temizleyemedi." , "Sanatçı farkı fark etme başlar." , "Birçok seneler geçti dönen yok seferinden."),
        mutableListOf("Aşağıdaki cümlelerin hangisinde ünsüz düşmesine uğramış birden çok sözcük kullanılmıştır?" , "Sevginin küçücük görünümünden sıcacık bir hikâye çıkardığını görmüştüm." , "Ufacık dedikodular bile büyük bir aileyi dağıtmak için yeterli olur." , "Evlerin minicik saçaklarından yere kadar buzlar sarkıyordu." , "Araba, büyücek bir binanın önünde sarsılarak durdu."),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val gorunum = binding.root
        setContentView(gorunum)

        soruveri.shuffle()

        yenisorulargoster()
    }

    fun yenisorulargoster() {

        binding.sorusayisi.text = getString(R.string.sayimsayi,sorusayi)

        val soru = soruveri[0]

        binding.soru.text = soru[0]
        dogrucevap = soru[1]

        soru.removeAt(0)

        soru.shuffle()

        binding.cevapbtn1.text = soru[0]
        binding.cevapbtn2.text = soru[1]
        binding.cevapbtn3.text = soru[2]
        binding.cevapbtn4.text = soru[3]

        soruveri.removeAt(0)

    }

    fun cevapkontrol(view: View) {

        val cevapbtn: Button = findViewById(view.id)
        val Btnyazi = cevapbtn.text.toString()

        val uyaribasligi: String
        if (Btnyazi == dogrucevap) {
            uyaribasligi = "Dogru Cevap!"
            dogrucevapsayim++
        } else {
            uyaribasligi = "Yanlış Cevap."
        }

        AlertDialog.Builder(this)
            .setTitle(uyaribasligi)
            .setMessage("Cevap: $dogrucevap")
            .setPositiveButton("Tamam") {diyalogarayuzu, i ->
                sorusayikontrol()
            }
            .setCancelable(false)
            .show()
    }

    fun sorusayikontrol() {
        if (sorusayi == SORU_SAYI) {

            val intent = Intent(this@MainActivity,SonucActivity::class.java)
            intent.putExtra("DOGRU_CEVAP_SAYIM", dogrucevapsayim)
            startActivity(intent)

        } else {
            sorusayi++
            yenisorulargoster()
        }
    }
}