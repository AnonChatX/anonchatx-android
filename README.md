# AnonChatX

**Decentralized messaging for high-threat environments.**  
Online over Tor. Fully functional offline. No servers. No trackers.

AnonChatX is a privacy-first communication tool designed for situations where
networks are monitored, infrastructure is hostile, and trust assumptions fail.
It is built for people who cannot afford to be naive about surveillance,
centralization, or metadata.

####
⬇️ **Download the latest release (APK):**  
https://github.com/AnonChatX/anonchatx-android/releases/latest

🔐 **Verify checksums & signatures:**  
See the release notes for verification instructions.

---

## What AnonChatX is

AnonChatX is an **Android-only**, decentralized communications suite that provides:

- **Secure messaging**  
  Peer-to-peer communication with no central servers to seize or subpoena.

- **Tor support (online mode)**  
  Route traffic through Tor, with bridge support when Tor is blocked.

- **Offline operation**  
  Communicate without the internet using:
    - Wi-Fi
    - Bluetooth
    - External storage (store-and-forward)

- **Private payments (Monero)**  
  In-chat payment requests using unique subaddresses to avoid persistent identifiers.

- **Offline maps & location sharing**  
  Share locations and navigate using imported map tiles — no external map servers.

AnonChatX is designed to **reduce metadata exposure**, not to promise magical or absolute anonymity.

---

## Threat model (high level)

AnonChatX assumes that, in serious cases:

- Network traffic may be monitored
- Blocking, throttling, and manipulation may occur
- Contacts may be compromised over time
- Physical device inspection is a realistic risk

Design choices prioritize:
- No centralized infrastructure
- Offline fallback paths
- Metadata discipline
- Pragmatic safety tools for coercive environments

A full threat model is documented separately.

---

## Project philosophy

AnonChatX is:

- **Anti-authoritarian by design**  
  Incompatible with centralized control, mass surveillance, and coercive platforms.

- **Open and auditable**  
  Security through transparency, not marketing claims.

- **Community-governed**  
  No sponsors, no investors, no institutional control.

- **Honest about limits**  
  Trade-offs are documented. Assumptions are explicit.

📜 **Read the full manifesto:**  
➡️ [MANIFESTO.md](./MANIFESTO.md)

---

## Platform support

- ✅ **Android** — supported
- ❌ **iOS** — intentionally not supported

iOS imposes architectural and policy constraints that prevent the level of
network control, offline operation, and user agency required by AnonChatX’s
threat model. Supporting iOS would require compromises this project is not
willing to make.

---

## Installation & releases

AnonChatX is distributed **outside centralized app stores**.

- Signed APKs
- Published checksums
- Verifiable releases

Official releases are published via GitHub.

➡️ See releases and verification instructions in the documentation.

### About centralized app stores

AnonChatX’s threat model assumes that distribution channels themselves can
leak metadata and impose constraints that are incompatible with high-risk use.

Centralized app stores, including Google Play, introduce risks such as:

- **Mandatory platform services**  
  Many Android devices require Google Play Services, increasing exposure to
  device-level identifiers and behavioral signals.

- **Automated scanning and policy enforcement**  
  Apps may be statically or dynamically analyzed, and removed or restricted
  without notice.

- **Metadata exposure**  
  Install timing, update behavior, IP-level correlation, and account linkage
  may be observable at the distribution layer.

- **Policy constraints on security tools**  
  Applications that include strong encryption, Tor integration, or mechanisms
  designed to bypass network blocking may face additional scrutiny or removal.

### For these reasons, AnonChatX prioritizes direct APK distribution and F-Droid (soon), where users can independently verify builds and minimize reliance on centralized infrastructure.

---

## Open source & licensing

AnonChatX is open source and developed transparently.

Security relies on:
- Public, auditable code
- Independent review
- The ability to fork and verify builds

Licensing and attribution information is included in this repository.
---

## Contributing

AnonChatX is an early-stage project. Contributions of all kinds are welcome:

- Android development
- Networking & transport layers
- Cryptography review
- UX for high-risk users
- Documentation & threat analysis

➡️ See [CONTRIBUTING.md](./CONTRIBUTING.md)

---

## Support & sustainability

AnonChatX is independent and community-supported.

Support may include:
- Code contributions
- Infrastructure
- Testing devices
- Financial support

Financial contributions are accepted in a privacy-respecting way:

**Monero (XMR) — preferred**
85kkMcowoNwQwji3ugetQvfwismWuvGWWLWfhWoyLjqnDAcgsnpVMsWG76zMm3zEb9WfUcJqBCKZKQ8wVox58tfr7dY7CXF

**Bitcoin (BTC) — accepted (public by default)**
bc1qqjw2qyj276jkwdd0wxm4y4vyggsmr73y9nm066

For QR codes, and updated donation information, see:
https://anonchatx.org/#supporters
(onion mirror soon available)

Part of the project’s resources are used to support the Tor ecosystem
by running relays and bridges.

**Sponsorship does not equal influence.**

---

## Disclaimer

AnonChatX is designed for real-world risk, but no software can eliminate all
threats. Users are responsible for understanding their own environment,
operational security, and legal context.

Privacy is a condition you defend — not a checkbox you enable.

AnonChatX derives from the Briar project.
Attribution and license details are provided in the repository.