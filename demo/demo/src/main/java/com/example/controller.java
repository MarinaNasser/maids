@RestController
@RequestMapping("/api/devices")
public class DeviceController {
    @Autowired
    private DeviceRepository deviceRepository;
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{id}")
    public ResponseEntity<Device> getDeviceById(@PathVariable Long id) {
        Device device = deviceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Device not found"));
        return ResponseEntity.ok().body(device);
    }

    @PostMapping("/")
    public Device addDevice(@RequestBody Device device) {
        return deviceRepository.save(device);
    }

    @PostMapping("/predict/{id}")
    public ResponseEntity<Device> predictPrice(@PathVariable Long id) {
        Device device = deviceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Device not found"));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(device.getSpecifications(), headers);

        ResponseEntity<Integer> result = restTemplate.postForEntity("http://localhost:5000/predict", entity, Integer.class);
        device.setPriceRange(result.getBody());
        deviceRepository.save(device);

        return ResponseEntity.ok(device);
    }
}
