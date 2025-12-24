import requests
import sys

def perform_recon(target_url):
    """
    Scans a target URL for potentially exposed API endpoints and sensitive files.
    """
   
    wordlist = [
        "/api/v1/admin",
        "/api/v1/config",
        "/api/v2/users",
        "/.env",
        "/.git/",
        "/swagger.json",
        "/phpinfo.php",
        "/backup.zip"
    ]

    print(f"[*] Starting reconnaissance on: {target_url}\n")

    for path in wordlist:
        url = f"{target_url.rstrip('/')}{path}"
        try:
            response = requests.get(url, timeout=5)
            
           
            if response.status_code == 200:
                print(f"[!] EXPOSED: {url} (Status: 200)")
            elif response.status_code == 403:
                print(f"[*] PROTECTED: {url} (Status: 403)")
                
        except requests.exceptions.RequestException as e:
            print(f"[X] Error connecting to {url}: {e}")

if __name__ == "__main__":
    if len(sys.argv) < 2:
        print("Usage: python3 api_recon.py <target_url>")
    else:
        target = sys.argv[1]
        perform_recon(target)
