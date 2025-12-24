# api-bug-identifier
A lightweight Python-based reconnaissance tool designed to automate the discovery of exposed API endpoints and sensitive configuration files. This tool was developed to streamline the initial stages of a web penetration test or CTF challenge.
Features
Endpoint Discovery: Scans for common high-risk paths (e.g., /.env, /api/v1/admin, /config).

Response Analysis: Identifies server responses to distinguish between unauthorized access (401/403) and total exposure (200).

Modular Design: Easily extensible to include custom wordlists or JWT header analysis.

Installation & Usage
Clone the repo: git clone https://github.com/nerd-00/api-scanner

Run the script: python3 scanner.py --url https://target-api.com

Disclaimer
This tool is for educational and authorized security testing purposes only.
