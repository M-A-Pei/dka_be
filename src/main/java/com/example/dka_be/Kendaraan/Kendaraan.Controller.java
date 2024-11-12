public class KendaraanController {
    private final KendaraanService kendaraanService;

    @Autowired
    public KendaraanController(KendaraanService kendaraanService) {
        this.kendaraanService = kendaraanService;
    }

    @GetMapping("/kendaraan")
    public List<Kendaraan> getAllKendaraan() {
        return kendaraanService.getAllKendaraan();
    }

    @PostMapping("/kendaraan")
    public Kendaraan createKendaraan(@RequestBody Kendaraan kendaraan) {
        return kendaraanService.createKendaraan(kendaraan);
    }
}